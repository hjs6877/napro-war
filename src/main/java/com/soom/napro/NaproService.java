package com.soom.napro;

import com.soom.entity.NaproData;
import com.soom.entity.NaproEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

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

    @Transactional
    public void registerNaproData(int eventId, NaproData naproData) {
        NaproEvent naproEvent = naproDao.findByEventId(eventId);


        if(naproEvent == null){
            naproEvent = new NaproEvent();
            Date curDate = new Date();

            naproEvent.setTitle(naproData.getVaginaViscosity().concat(naproData.getVaginaState())); // TODO 결과 코드 생성해야 됨.
            naproEvent.setStartDate(curDate);
            naproEvent.setEndDate(curDate);

            // 키 전략이 Identity이므로 영속화를 먼저 시키고 난 후, event_id를 얻어서 naproData를 저장한다.
            naproDao.save(naproEvent);

            naproData.setEventId(naproEvent.getEventId());
            naproEvent.addNaproData(naproData);

        }else{
            naproEvent.getNaproDataList().add(naproData);
            naproDao.save(naproEvent);  // TODO findByEventId로 영속화 했으므로 save 안해도 되지 않을까? 테스트 돌려보기
        }


    }
}
