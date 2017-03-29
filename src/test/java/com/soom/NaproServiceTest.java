package com.soom;

import com.soom.entity.NaproData;
import com.soom.entity.NaproEvent;
import com.soom.napro.NaproDao;
import com.soom.napro.NaproService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * summary:
 * <p> description:
 * <p><b>History:</b>
 * - 작성자, 2017-03-29 최초 작성<br/>
 *
 * @author Kevin
 * @see
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NaproServiceTest {
    @Autowired
    private NaproService naproService;

    @Autowired
    private NaproDao naproDao;

    @Test
    @Transactional
    public void registerNaproDataTest(){
        NaproData naproData = new NaproData();
        naproData.setMenseQuantity("L");
        naproData.setMenseState("R");
        naproData.setVaginaViscosity("10");
        naproData.setVaginaState("B");
        naproData.setCreateDate(new Date());

        naproService.registerNaproData(1, naproData);

        NaproEvent naproEvent = naproDao.findByEventId(1);

        assertEquals(naproEvent.getTitle(), "10B");
        assertEquals(naproEvent.getNaproDataList().size(), 1);
    }
}
