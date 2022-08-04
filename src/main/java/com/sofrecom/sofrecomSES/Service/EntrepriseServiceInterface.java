package com.sofrecom.sofrecomSES.Service;
import com.sofrecom.sofrecomSES.Model.Entreprise;
import java.util.List;

public interface EntrepriseServiceInterface {
    List<Entreprise> getAllEntreprises();
    Entreprise getEntrepriseById(Long id);
    Entreprise addEntreprise(Entreprise entreprise);
    Entreprise updateEntreprise(Entreprise entreprise);
    void deleteEntreprise(Long id);
}

