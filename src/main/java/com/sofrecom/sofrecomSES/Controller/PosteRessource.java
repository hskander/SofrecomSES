package com.sofrecom.sofrecomSES.Controller;

import com.sofrecom.sofrecomSES.Model.Poste;
import com.sofrecom.sofrecomSES.Service.PosteServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;

@RestController
@RequestMapping("/Poste")
public class PosteRessource {
    private final PosteServiceInterface posteService;
    @Autowired
    public PosteRessource(PosteServiceInterface posteService) {

        this.posteService = posteService;
    }

    @PostMapping("/addPoste")
    public ResponseEntity<Poste> addPoste(@RequestBody Poste poste){
        return new ResponseEntity<>(this.posteService.addPoste(poste), HttpStatus.CREATED);
    }
}
