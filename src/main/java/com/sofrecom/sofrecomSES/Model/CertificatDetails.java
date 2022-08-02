package com.sofrecom.sofrecomSES.Model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class CertificatDetails implements Serializable {

    @Id
    @Column(nullable = false , updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date dateDebutFormation;
    @Temporal(TemporalType.DATE)
    private Date dateObtention;
    private float note;

    @ManyToOne
    private Certificat certificat;
    @ManyToOne
    private CentreFormation centreFormation;
    @ManyToOne
    private Employe employe;
}
