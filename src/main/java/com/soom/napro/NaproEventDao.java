package com.soom.napro;

import com.soom.entity.NaproEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * summary:
 * <p> description:
 * <p><b>History:</b>
 * - 작성자, 2017-03-29 최초 작성<br/>
 *
 * @author Kevin
 * @see
 */
@Repository
public interface NaproEventDao extends JpaRepository<NaproEvent, Integer> {
    NaproEvent findById(int id);
    void delete(int eventId);
    NaproEvent save(NaproEvent naproEvent);
}
