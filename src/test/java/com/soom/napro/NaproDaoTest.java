package com.soom.napro;

import com.soom.entity.NaproEvent;
import com.soom.napro.NaproDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

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
public class NaproDaoTest {
    @Autowired
    private NaproDao naproDao;

    @Test
    public void findByEventIdTest(){
        NaproEvent naproEvent = naproDao.findByEventId(1);
        assertTrue(naproEvent == null);
    }


}
