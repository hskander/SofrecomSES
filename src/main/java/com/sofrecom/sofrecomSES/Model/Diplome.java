package com.sofrecom.sofrecomSES.Model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data
public class Diplome implements Serializable {
    @Id
    @Column(nullable = false , updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String diplome;
    private String descriptionDiplome;
}
