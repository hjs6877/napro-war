package com.soom.napro;

import com.soom.entity.NaproData;
import com.soom.entity.NaproEvent;
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
    public static String DELETE_NAPRODATA_SUCCESS = "delete-naprodata-success";
    public static String DELETE_NAPROEVENT_SUCCESS = "delete-naproevent-success";

    @Autowired
    private NaproEventDao naproEventDao;

    @Autowired
    private NaproDataDao naproDataDao;

    @Autowired
    private UserDao userDao;

    public List<NaproEvent> findAllNaproEvent(){
        List<NaproEvent> naproEvents = naproEventDao.findAll();
        for(NaproEvent naproEvent : naproEvents){
            naproEvent.setNaproDataList(null);
        }
        return naproEvents;
    }
    public List<NaproData> findNaproDataByEventId(int eventId){
        List<NaproData> naproDataList = naproDataDao.findByEventId(eventId);
        return naproDataList;
    }

    @Transactional
    public NaproEvent registerNaproData(String userId, NaproData naproData, String startDate) {
        String year = startDate.substring(0, 4);
        String month = startDate.substring(4, 6);
        String day = startDate.substring(6);
        String start = year + "-" + month + "-" + day;

        int score = 0;
        String totalCode = "";
        Date curDate = new Date();

        NaproEvent naproEvent = naproEventDao.findById(naproData.getEventId());
        NaproEvent resultEvent;


        Map<String, Object> calculatedData = calculateNaproData(naproData);

        score = (int) calculatedData.get("score");
        totalCode = (String) calculatedData.get("totalCode");

        naproData.setScore(score);
        naproData.setTotalCode(totalCode);

        naproData.setCreateDate(curDate);
        naproData.setModifyDate(curDate);

        if(naproEvent == null){
            naproEvent = new NaproEvent();

            naproEvent.setStart(start);
            naproEvent.setEnd(start);
            naproEvent.setUserId(userId);

            resultEvent = naproEventDao.save(naproEvent);
            naproData.setEventId(resultEvent.getId());
            resultEvent.addNaproData(naproData);
        }else{
            naproData.setEventId(naproEvent.getId());
            naproEvent.addNaproData(naproData);
        }





        /**
         * score가 가장 큰 NaproData를 찾는다.
         * 해당 NaproData의 total code를 넣어준다.
         */
        List<NaproData> naproDataList = naproEvent.getNaproDataList();
        int maxScore = 0;
        String maxTotalCode = getMaxTotalCode(naproEvent);
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


    @Transactional
    public NaproEvent modifyNaproData(NaproData naproData) {
        NaproData recentNaproData = naproDataDao.findByNaproDataId(naproData.getNaproDataId());
        NaproEvent naproEvent = naproEventDao.findById(naproData.getEventId());
        int score;
        String totalCode;
        Date curDate = new Date();

        Map<String, Object> calculatedData = calculateNaproData(naproData);

        score = (int) calculatedData.get("score");
        totalCode = (String) calculatedData.get("totalCode");

        naproData.setScore(score);
        naproData.setTotalCode(totalCode);
        naproData.setCreateDate(recentNaproData.getCreateDate());
        naproData.setModifyDate(curDate);

        naproDataDao.save(naproData);

        /**
         * score가 가장 큰 NaproData를 찾는다.
         * 해당 NaproData의 total code를 넣어준다.
         */
        String maxTotalCode = getMaxTotalCode(naproEvent);


        naproEvent.setTitle(maxTotalCode);


        return naproEvent;
    }

    @Transactional
    public void deleteNaproEvent(int eventId){
        naproEventDao.delete(eventId);
    }

    @Transactional
    public void deleteNaproData(int naproDataId){
        naproDataDao.delete(naproDataId);
    }

    private String getMaxTotalCode(NaproEvent naproEvent) {
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
        return maxTotalCode;
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
