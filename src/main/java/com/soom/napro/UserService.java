package com.soom.napro;

import com.soom.entity.User;
import com.soom.utils.CipherUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * summary:
 * <p> description:
 * <p><b>History:</b>
 * - 작성자, 2017-04-19 최초 작성<br/>
 *
 * @author Kevin
 * @see
 */
@Service
public class UserService {
    public static String LOGIN_FAIL_CODE = "login-fail";
    public static String LOGIN_FAIL_MSG = "아이디 또는 비밀번호가 틀립니다.";
    public static String LOGIN_SUCCESS_CODE = "login-success";
    public static String LOGIN_SUCCESS_MSG = "";
    public static String LOGOUT_SUCCESS_CODE = "logout-success";
    public static String LOGOUT_SUCCESS_MSG = "";
    public static String LOGIN_AUTO_DENY = "login-auto-deny";
    public static String LOGIN_AUTO_ALLOW = "login-auto-allow";
    @Autowired
    private UserDao userDao;

    public User registerUser(User user){
        /**
         * 패스워드 암호화
         * 등록
         */
        String hashedPassword = CipherUtil.hash(user.getPassword());
        user.setPassword(hashedPassword);
        user.setCreateDate(new Date());

        User savedUser = userDao.save(user);
        return savedUser;
    }

    public User modifyUser(User user){
        User savedUser = userDao.save(user);
        return savedUser;
    }

    public User findUserByIdAndPassword(User user){
        String id = user.getId();
        String password = user.getPassword();
        String hashedPassword = CipherUtil.hash(password);

        User resultUser = userDao.findByIdAndPassword(id, hashedPassword);
        return resultUser;
    }

    public User findUserByIdAndSalt(User user){
        String id = user.getId();
        String salt = user.getSalt();

        User resultUser = userDao.findByIdAndSalt(id, salt);
        return resultUser;
    }

    public User findUserById(String userId){
        User resultUser = userDao.findById(userId);
        return resultUser;
    }
}
