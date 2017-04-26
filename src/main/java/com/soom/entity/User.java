package com.soom.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * summary:
 * <p> description:
 * <p><b>History:</b>
 * - 작성자, 2017-04-19 최초 작성<br/>
 *
 * @author Kevin
 * @see
 */
@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @Column(name = "user_id")
    private String id;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<NaproEvent> naproEventList;

    public void addNaproEvent(NaproEvent naproEvent){
        if( naproEventList == null ){
            naproEventList = new ArrayList<>();
        }
        naproEventList.add(naproEvent);
    }
}
