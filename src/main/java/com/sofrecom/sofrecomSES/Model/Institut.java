package com.sofrecom.sofrecomSES.Model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Institut implements Serializable {
    @Id
    @Column(nullable = false , updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String Institut;
    private String description;
    private String adresse;
    private String email ;
    private Long numTel;


}
