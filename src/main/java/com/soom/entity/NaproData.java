package com.soom.entity;

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

    @Column(name = "mense_quantity")
    private String menseQuantity;

    @Column(name = "mense_state")
    private String menseState;

    @Column(name = "vagina_viscosity")
    private String vaginaViscosity;

    @Column(name = "vagina_viscosity_score")
    private int vaginaViscosityScore;

    @Column(name = "vagina_state")
    private String vaginaState;

    @Column(name = "vagina_state_score")
    private int vaginaStateScore;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "modify_date")
    private Date modifyDate;

    @Column(name = "event_id")
    private int eventId;
}
