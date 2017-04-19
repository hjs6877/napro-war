package com.soom.napro;

import com.soom.entity.NaproData;
import com.soom.entity.NaproEvent;
import com.soom.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * summary:
 * <p> description:
 * <p><b>History:</b>
 * - 작성자, 2017-03-29 최초 작성<br/>
 *
 * @author Kevin
 * @see
 */
@Service
public class NaproService {
    @Autowired
    private NaproDao naproDao;

    public List<NaproEvent> findAllNaproEvent(){
        List<NaproEvent> naproEvents = naproDao.findAll();
        for(NaproEvent naproEvent : naproEvents){
            naproEvent.setNaproDataList(null);
        }
        return naproEvents;
    }
    public List<NaproData> findNaproDataByeventId(int eventId){
        NaproEvent naproEvent = naproDao.findById(eventId);
        List<NaproData> naproDatas = naproEvent != null ? naproEvent.getNaproDataList() : null;
        return naproDatas;
    }

    @Transactional
    public NaproEvent registerNaproData(User user, NaproData naproData, String startDate) {
        String year = startDate.substring(0, 4);
        String month = startDate.substring(4, 6);
        String day = startDate.substring(6);
        String start = year + "-" + month + "-" + day;
        NaproEvent naproEvent = naproDao.findById(naproData.getId());
        int score = 0;
        String totalCode = "";
        Date curDate = new Date();

        if(naproEvent == null){
            naproEvent = new NaproEvent();

            naproEvent.setUser(user);
            naproEvent.setStart(start);
            naproEvent.setEnd(start);

            // 키 전략이 Identity이므로 영속화를 먼저 시키고 난 후, event_id를 얻어서 naproData를 저장한다.
            naproDao.save(naproEvent);

        }

        Map<String, Object> calculatedData = calculateNaproData(naproData);

        score = (int) calculatedData.get("score");
        totalCode = (String) calculatedData.get("totalCode");

        naproData.setId(naproEvent.getId());
        naproData.setScore(score);
        naproData.setTotalCode(totalCode);

        naproData.setCreateDate(curDate);
        naproData.setModifyDate(curDate);
        naproEvent.addNaproData(naproData);

        /**
         * score가 가장 큰 NaproData를 찾는다.
         * 해당 NaproData의 total code를 넣어준다.
         */
        List<NaproData> naproDataList = naproEvent.getNaproDataList();
        int maxScore = 0;
        String maxTotalCode = "";
        for(NaproData naData : naproDataList){
            int sc = naData.getScore();
            String code = naData.getTotalCode();

            if(naData.getScore() >= maxScore){
                maxScore = sc;
                maxTotalCode = code;
            }
        }

        naproEvent.setTitle(maxTotalCode);

        return naproEvent;
    }

    private Map<String, Object> calculateNaproData(NaproData naproData) {
        int score = 0;
        String totalCode = "";

        Map<String, Object> calculatedData = new HashMap<>();

        if(naproData.getMense().equals(NaproEnum.M_NO)){
            NaproEnum vaginaLevel = naproData.getVaginaLevel();
            NaproEnum S1_D = naproData.getState1D();
            NaproEnum S1_W = naproData.getState1W();
            NaproEnum S1_S = naproData.getState1S();
            NaproEnum S2_C = naproData.getState2C();
            NaproEnum S2_CK = naproData.getState2CK();
            NaproEnum S2_G = naproData.getState2G();
            NaproEnum S2_K = naproData.getState2K();
            NaproEnum S2_L = naproData.getState2L();
            NaproEnum S2_P = naproData.getState2P();
            NaproEnum S2_Y = naproData.getState2Y();

            if(vaginaLevel != null){
                score += vaginaLevel.getScore();
                totalCode += vaginaLevel.getCode();
            }
            if(S1_D != null){
                score += S1_D.getScore();
                totalCode += S1_D.getCode();
            }
            if(S1_W != null){
                score += S1_W.getScore();
                totalCode += S1_W.getCode();
            }
            if(S1_S != null){
                score += S1_S.getScore();
                totalCode += S1_S.getCode();
            }
            if(S2_C != null){
                score += S2_C.getScore();
                totalCode += S2_C.getCode();
            }
            if(S2_CK != null){
                score += S2_CK.getScore();
                totalCode += S2_CK.getCode();
            }
            if(S2_G != null){
                score += S2_G.getScore();
                totalCode += S2_G.getCode();
            }
            if(S2_K != null){
                score += S2_K.getScore();
                totalCode += S2_K.getCode();
            }
            if(S2_L != null){
                score += S2_L.getScore();
                totalCode += S2_L.getCode();
            }
            if(S2_P != null){
                score += S2_P.getScore();
                totalCode += S2_P.getCode();
            }
            if(S2_Y != null){
                score += S2_Y.getScore();
                totalCode += S2_Y.getCode();
            }

            if(totalCode.isEmpty()){
                totalCode += naproData.getMense().getCode();
            }
        }else{
            NaproEnum mense = naproData.getMense();
            String existMucus = naproData.getExistMucus();

            totalCode += mense.getCode() + existMucus;
        }

        calculatedData.put("score", score);
        calculatedData.put("totalCode", totalCode);

        return calculatedData;
    }
}
