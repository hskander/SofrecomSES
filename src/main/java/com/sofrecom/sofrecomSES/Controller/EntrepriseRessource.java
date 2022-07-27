package com.sofrecom.sofrecomSES.Controller;


import com.sofrecom.sofrecomSES.Service.EntrepriseServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Entreprise")
public class EntrepriseRessource {
    private final EntrepriseServiceInterface entrepriseService;
    @Autowired
    public EntrepriseRessource(EntrepriseServiceInterface entrepriseService) {
        this.entrepriseService = entrepriseService;
    }

}
