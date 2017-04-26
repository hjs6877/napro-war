package com.soom.napro;

import com.soom.entity.NaproData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * summary:
 * <p> description:
 * <p><b>History:</b>
 * - 작성자, 2017-04-25 최초 작성<br/>
 *
 * @author Kevin
 * @see
 */
@Repository
public interface NaproDataDao extends JpaRepository<NaproData, Integer> {
    NaproData findByNaproDataId(int naproDataId);
    List<NaproData> findByEventId(int eventId);
    NaproData save(NaproData naproData);
    void delete(int naproDataId);
}
