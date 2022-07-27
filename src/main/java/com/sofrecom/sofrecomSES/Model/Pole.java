package com.sofrecom.sofrecomSES.Model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Pole implements Serializable {
    @Id
    @Column(nullable = false , updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long matricule;
    @Column(nullable = false)
    private String pole;
    private String description;
    private String responsablePole;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pole")
    private List<Employe> employes;

    @ManyToOne
    private Direction direction;

    @OneToOne
    private Employe manager;
}
