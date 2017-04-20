package com.soom.napro;

import com.soom.entity.NaproData;
import com.soom.entity.User;
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
    private UserService userService;

    @Autowired
    private NaproDao naproDao;

    @Test
    @Transactional
    public void registerNaproDataTest(){
        User user = new User();
        user.setId("soomee");
        user.setPassword("7725");

        userService.registerUser(user);

        NaproData naproData1 = new NaproData();
        naproData1.setMense(NaproEnum.M_NO);
        naproData1.setVaginaLevel(NaproEnum.L_FOUR);
        naproData1.setState1D(NaproEnum.S1_D);
        naproData1.setState2L(NaproEnum.S2_L);
        naproData1.setCreateDate(new Date());
        naproData1.setId(1);



        naproService.registerNaproData(user.getId(), naproData1, "2017-04-04");



        assertEquals(naproData1.getTotalCode(), "4DL");

    }
}
