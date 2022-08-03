package com.sofrecom.sofrecomSES.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class DiplomeDetails implements Serializable {
    @Id
    @Column(nullable = false , updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date dateDebutFomation;
    @Temporal(TemporalType.DATE)
    private Date dateObtention;
    private String mention;

    @ManyToOne
    private Diplome diplome;
    @ManyToOne
    private Institut institut;
    @JsonIgnore
    @ManyToOne
    private Employe employe;
}
