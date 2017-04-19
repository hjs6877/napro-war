package com.soom.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * summary:
 * <p> description:
 * <p><b>History:</b>
 * - 작성자, 2017-03-29 최초 작성<br/>
 *
 * @author Kevin
 * @see
 */
@Entity
@Table(name = "napro_event")
@Data
public class NaproEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "event_id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "start_date")
    private String start;

    @Column(name = "end_date")
    private String end;

    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id")
    private List<NaproData> naproDataList;

    @OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public void addNaproData(NaproData naproData){
        if( naproDataList == null ){
            naproDataList = new ArrayList<NaproData>();
        }
        naproDataList.add(naproData);
    }
}
