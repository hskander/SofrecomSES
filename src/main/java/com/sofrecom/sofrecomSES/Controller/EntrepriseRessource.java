package com.sofrecom.sofrecomSES.Controller;
import com.sofrecom.sofrecomSES.Model.Entreprise;
import com.sofrecom.sofrecomSES.Service.EntrepriseService;
import com.sofrecom.sofrecomSES.Service.EntrepriseServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Entreprise")
public class EntrepriseRessource {
    private final EntrepriseServiceInterface entrepriseService;

    @Autowired
    public EntrepriseRessource(EntrepriseService entrepriseService) {
        this.entrepriseService = entrepriseService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Entreprise>> getAllEntreprises() {
        List<Entreprise> entreprises = entrepriseService.getAllEntreprises();
        return new ResponseEntity<>(entreprises, HttpStatus.OK);

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Entreprise> getEntrepriseById(@PathVariable("id") Long id) {
        Entreprise entreprise= entrepriseService.getEntrepriseById(id);
        return new ResponseEntity<>(entreprise, HttpStatus.OK);

    }

    @PostMapping("/add")
    public ResponseEntity<Entreprise> AddEntreprise(@RequestBody Entreprise entreprise) {
        Entreprise newEntreprise = entrepriseService.addEntreprise(entreprise);
        return new ResponseEntity<>(newEntreprise, HttpStatus.CREATED);

    }
    @PutMapping("/update")
    public ResponseEntity<Entreprise> UpdateEntreprise(@RequestBody Entreprise entreprise) {
        Entreprise updateEntreprise = entrepriseService.updateEntreprise(entreprise);
        return new ResponseEntity<>(updateEntreprise, HttpStatus.OK);


    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> DeleteEntreprise(@PathVariable("id") Long id) {
        entrepriseService.deleteEntreprise(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }


}




















