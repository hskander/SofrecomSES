package com.sofrecom.sofrecomSES.Controller;

import com.sofrecom.sofrecomSES.Service.ProjetServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Projet")
public class ProjetRessource {
    private final ProjetServiceInterface projetService;
    @Autowired
    public ProjetRessource(ProjetServiceInterface projetService) {
        this.projetService = projetService;
    }
}
