package com.sofrecom.sofrecomSES.Model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class Diplome implements Serializable {
    @Id
    @Column(nullable = false , updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long matricule;
    private String diplome;
    @Temporal(TemporalType.DATE)
    private Date dateDebutFomation;
    @Temporal(TemporalType.DATE)
    private Date datefinFormation;
    private String descriptionDiplome;

    @ManyToOne
    private Institut institut;

}
