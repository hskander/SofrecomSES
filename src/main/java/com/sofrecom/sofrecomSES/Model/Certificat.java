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
    private String descriptionCertificat;
    private boolean enLigne;



}
