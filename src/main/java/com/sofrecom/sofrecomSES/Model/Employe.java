package com.sofrecom.sofrecomSES.Model;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Employe implements Serializable {
    @Id
    @Column(nullable = false , updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false , updatable = false)
    private String employeCode;
    //@Column(nullable = false)
    private String nom;
    //@Column(nullable = false)
    private String prenom;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private String adresse;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private String LieuNaissance;
    private String Nationalite;
    //@Column(nullable = false)
    private String mail;
    @Temporal(TemporalType.DATE)
    private Date dateRecrut;
    @Temporal(TemporalType.DATE)
    private Date dateDepart;
    //urgence
    //@Column(nullable = false)
    private Long numTel;
    private String nomUrgence;
    private Long numUrgence;
    private String relationUrgence;
    //urgence

    //cin Passeport
    private String numPasseport;
    @Temporal(TemporalType.DATE)
    private Date dateExpPasseport;
    //@Column(nullable = false , updatable = false)
    private Long numCin;
    @Temporal(TemporalType.DATE)
    private Date delivDate;
    //cin Passeport

    private String civilite;
    private String situationFam;
    private int nbEnfant;
    private Float SalaireBrute;

    //cnss
    private Boolean cnss;
    private String matriculeCnss;
    //cnss

    //Bank info
    private String bankName;
    private String swift;
    private Long rib;
    private String iban;
    //Bank info

    private Boolean enConge;

    //Les Relations
    @ManyToOne
    private Pole pole;
    @ManyToOne
    private Poste poste;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "employe")
    private List<Experience> experiences;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "employe")
    private List<CertificatDetails> ListCertificatDetails;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "employe")
    private List<DiplomeDetails> ListDiplomeDetails;

    @ManyToMany
    private List<Projet> projets;



}
