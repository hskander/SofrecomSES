package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Model.*;

import java.util.List;

public interface ProjetServiceInterface {
    Projet addProjet(Projet projet);
    List<Projet> getAllProjets();
    Projet getProjetById(Long id);
    Projet updateProjet(Projet e);
    void deleteProjet(Long id);
    Projet affecterEmployeToProjet(Long projetId,Long employeId);
}
