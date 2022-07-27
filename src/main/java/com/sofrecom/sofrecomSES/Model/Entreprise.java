package com.sofrecom.sofrecomSES.Model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Entreprise implements Serializable {
    @Id
    @Column(nullable = false , updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long matricule;
    @Column(nullable = false)
    private String entreprise;
    private String description;
    private String adresse;
    private String email ;
    private Long numTel;

}
