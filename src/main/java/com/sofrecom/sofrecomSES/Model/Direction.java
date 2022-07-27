package com.sofrecom.sofrecomSES.Model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Direction implements Serializable {
    @Id
    @Column(nullable = false , updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long matricule;
    @Column(nullable = false)
    private String direction;
    private String description;
    private String responsableDirection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "direction")
    private List<Pole> poles;
}
