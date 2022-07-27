package com.sofrecom.sofrecomSES.Model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Poste implements Serializable {
    @Id
    @Column(nullable = false , updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long matricule;
    @Column(nullable = false)
    private String poste;
    private String description;

    @OneToMany(/*cascade = CascadeType.ALL,*/ mappedBy = "poste")
    private List<Employe> employes;


}
