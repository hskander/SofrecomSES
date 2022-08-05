package com.sofrecom.sofrecomSES.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Long id;
    @Column(nullable = false)
    private String direction;
    private String description;
    private String responsableDirection;
    
    @JsonIgnore
    @OneToOne
    private Employe manager;
    @JsonIgnore
    @OneToMany(mappedBy = "direction")
    private List<Pole> poles;
}
