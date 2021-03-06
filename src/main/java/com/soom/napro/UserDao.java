package com.soom.napro;

import com.soom.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * summary:
 * <p> description:
 * <p><b>History:</b>
 * - 작성자, 2017-04-19 최초 작성<br/>
 *
 * @author Kevin
 * @see
 */
@Repository
public interface UserDao extends JpaRepository<User, String> {
    User findByIdAndPassword(String id, String password);
    User findByIdAndSalt(String id, String Salt);
    User findById(String id);
    User save(User user);
}
