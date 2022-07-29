package com.sofrecom.sofrecomSES.Model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class CentreFormation implements Serializable {
    @Id
    @Column(nullable = false , updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String centreFormationName;
    private String description;
    private String adresse;
    private String email ;
    private Long numTel;


    public CentreFormation(String centreFormationName ,String description,
                           String adresse,String email,Long numTel) {
        this.centreFormationName=centreFormationName;
        this.description=description;
        this.adresse = adresse;
        this.email=email;
        this.numTel=numTel;
    }

    public CentreFormation(){};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCentreFormationName() {
        return centreFormationName;
    }

    public void setCentreFormationName(String centreFormationName) {
        this.centreFormationName = centreFormationName;
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


    @Override
    public String toString() {
        return "CentreFormation{" +
                "id=" + id +
                ", centreFormationName='" + centreFormationName + '\'' +
                ", description='" + description + '\'' +
                ", adresse='" + adresse + '\'' +
                ", email='" + email + '\'' +
                ", numTel=" + numTel +
                '}';
    }
}
