package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Controller.EntrepriseRessource;
import com.sofrecom.sofrecomSES.Repository.EntrepriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntrepriseService implements EntrepriseServiceInterface {
    private final EntrepriseRepository entrepriseRepository;
    @Autowired
    public EntrepriseService(EntrepriseRepository entrepriseRepository) {
        this.entrepriseRepository = entrepriseRepository;
    }

}
