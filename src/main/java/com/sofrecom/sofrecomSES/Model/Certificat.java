package com.sofrecom.sofrecomSES.Model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class Certificat implements Serializable {
    @Id
    @Column(nullable = false , updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String certificat;
    private Date datefinFormation;
    private String descriptionDiplome;
    private boolean enLigne;

    @ManyToOne
    private CentreFormation centreFormation;

}
