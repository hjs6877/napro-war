package com.soom.napro;

import com.soom.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

/**
 * summary:
 * <p> description:
 * <p><b>History:</b>
 * - 작성자, 2017-04-19 최초 작성<br/>
 *
 * @author Kevin
 * @see
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    @Transactional
    public void registerUserTest(){
        User user = new User();
        user.setId("soomee");
        user.setPassword("7725");

        User savedUser = userService.registerUser(user);
        System.out.println("userId: " + savedUser.getId());
        System.out.println("userPassword: " + savedUser.getPassword());
        assertEquals(user.getId(), savedUser.getId());
    }
}
