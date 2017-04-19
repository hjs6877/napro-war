package com.soom.entity;

import lombok.Data;

import javax.persistence.*;
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
@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @OneToOne(mappedBy = "user")
    private NaproEvent naproEvent;
}
