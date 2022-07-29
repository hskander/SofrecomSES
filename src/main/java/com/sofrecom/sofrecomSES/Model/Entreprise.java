package com.sofrecom.sofrecomSES.Model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.lang.Override;

@Entity
@Data
public class Entreprise implements Serializable {
    @Id
    @Column(nullable = false , updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String entreprise;
    private String description;
    private String adresse;
    private String email ;
    private Long numTel;


    public Entreprise(String entreprise,String description ,
                      String adresse,String email,Long numTel) {
        this.entreprise = entreprise;
        this.description = description;
        this.adresse = adresse;
        this.email = email;
        this.numTel = numTel;

    }
    public Entreprise(){};
    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getNumTel() {
        return numTel;
    }

    public void setNumTel(Long numTel) {
        this.numTel = numTel;
    }

    public Long getMatricule() {
        return id;
    }

    public void setMatricule(Long matricule) {
        this.id = matricule;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "Matricule" + id+
                ", Entreprise='" +entreprise  + '\'' +
                ", Description='" + description + '\'' +
                ", Adresse=" + adresse+
                ", email=" + email +
                ", NumTel=" + numTel +
                '}';
    }
}




