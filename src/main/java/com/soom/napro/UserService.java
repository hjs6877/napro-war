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

    public User findUserByIdAndUser(User user){
        String id = user.getId();
        String password = user.getPassword();
        String hashedPassword = CipherUtil.hash(password);

        User resultUser = userDao.findByIdAndPassword(id, hashedPassword);
        return resultUser;
    }
}
