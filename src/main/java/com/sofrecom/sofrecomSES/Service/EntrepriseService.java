package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Exeption.UserNotFoundException;
import com.sofrecom.sofrecomSES.Model.Entreprise;
import com.sofrecom.sofrecomSES.Repository.EntrepriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrepriseService implements EntrepriseServiceInterface {
    private final EntrepriseRepository entrepriseRepository;

    @Autowired
    public EntrepriseService(EntrepriseRepository entrepriseRepository) {
        this.entrepriseRepository = entrepriseRepository;
    }
    @Override
    public Entreprise addEntreprise(Entreprise entreprise){return entrepriseRepository.save(entreprise);
    }
    @Override
    public List<Entreprise> getAllEntreprises(){
        return entrepriseRepository.findAll();
    }

    @Override
    public  Entreprise updateEntreprise(Entreprise entreprise){
        return entrepriseRepository.save(entreprise);
    }

    @Override
    public Entreprise getEntrepriseById(Long id){
        return entrepriseRepository.findEntrepriseById(id).
                orElseThrow(() -> new UserNotFoundException("Entreprise"+ id+"was not found"));
    }
    @Override
    public void deleteEntreprise(Long id){
        entrepriseRepository.deleteEntrepriseById(id);
    }

}