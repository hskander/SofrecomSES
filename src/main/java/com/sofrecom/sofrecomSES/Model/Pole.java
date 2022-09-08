package com.sofrecom.sofrecomSES.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Long id;
    @Column(nullable = false)
    private String pole;
    private String description;
    private String responsablePole;

    @OneToMany(mappedBy = "pole")
    private List<Employe> employes;

    @ManyToOne
    private Direction direction;


    @OneToOne
    private Employe manager;
}
