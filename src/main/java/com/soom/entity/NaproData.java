package com.soom.entity;

import com.soom.napro.NaproEnum;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

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
@Table(name = "napro_data")
@Data
public class NaproData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "napro_data_id")
    private int naproDataId;

    @Column(name = "mense")
    private NaproEnum mense;

    @Column(name = "exist_mucus")
    private String existMucus;

    @Column(name = "vagina_level")
    @Enumerated(EnumType.STRING)
    private NaproEnum vaginaLevel;

    @Column(name = "state1_d")
    @Enumerated(EnumType.STRING)
    private NaproEnum state1D;

    @Column(name = "state1_w")
    @Enumerated(EnumType.STRING)
    private NaproEnum state1W;

    @Column(name = "state1_s")
    @Enumerated(EnumType.STRING)
    private NaproEnum state1S;

    @Column(name = "state2_c")
    @Enumerated(EnumType.STRING)
    private NaproEnum state2C;

    @Column(name = "state2_ck")
    @Enumerated(EnumType.STRING)
    private NaproEnum state2CK;

    @Column(name = "state2_g")
    @Enumerated(EnumType.STRING)
    private NaproEnum state2G;

    @Column(name = "state2_k")
    @Enumerated(EnumType.STRING)
    private NaproEnum state2K;

    @Column(name = "state2_l")
    @Enumerated(EnumType.STRING)
    private NaproEnum state2L;

    @Column(name = "state2_p")
    @Enumerated(EnumType.STRING)
    private NaproEnum state2P;

    @Column(name = "state2_y")
    @Enumerated(EnumType.STRING)
    private NaproEnum state2Y;

    @Column(name = "score")
    private int score;

    @Column(name = "total_code")
    private String totalCode;


    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modify_date")
    private Date modifyDate;

    @Column(name = "event_id")
    private int eventId;
}
