package com.soom.napro;

import com.soom.entity.NaproEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
public class NaproEventDaoTest {
    @Autowired
    private NaproEventDao naproEventDao;

    @Test
    public void findByEventIdTest(){
        NaproEvent naproEvent = naproEventDao.findById(1);
//        assertTrue(naproEvent == null);
    }


}
