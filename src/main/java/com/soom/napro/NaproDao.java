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
public interface NaproDao extends JpaRepository<NaproEvent, Integer> {
    NaproEvent findByEventId(int eventId);
}
