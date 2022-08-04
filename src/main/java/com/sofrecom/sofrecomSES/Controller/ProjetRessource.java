package com.sofrecom.sofrecomSES.Controller;

import com.sofrecom.sofrecomSES.Model.Employe;
import com.sofrecom.sofrecomSES.Model.Projet;
import com.sofrecom.sofrecomSES.Service.ProjetServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Projet")
public class ProjetRessource {
    private final ProjetServiceInterface projetService;
    @Autowired
    public ProjetRessource(ProjetServiceInterface projetService) {
        this.projetService = projetService;
    }

    @GetMapping("/allProjets")
    public ResponseEntity<List<Projet>> gettAllProjets(){
        List<Projet> projets=this.projetService.getAllProjets();
        return new ResponseEntity<>(projets, HttpStatus.OK);
    }
    @GetMapping("/findProjetById")
    public ResponseEntity<Projet> findProjetById(@RequestParam("id") Long id){
        Projet projet= this.projetService.getProjetById(id);
        return new ResponseEntity<>(projet,HttpStatus.OK);
    }
    @DeleteMapping("/deleteProjet")
    public ResponseEntity<?> deleteProjet(@RequestParam("id") Long id){
        this.projetService.deleteProjet(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/addProjet")
    public ResponseEntity<Projet> addEmployee(@RequestBody Projet projet){
        return new ResponseEntity<>(this.projetService.addProjet(projet), HttpStatus.CREATED);
    }
    @PutMapping("/updateProjet")
    public ResponseEntity<Projet> updateProjet(@RequestBody Projet projet){
        return new ResponseEntity<>(this.projetService.updateProjet(projet),HttpStatus.OK);
    }

    @PutMapping("/affecterEmployeToProjet")
    public ResponseEntity<Projet> affecterEmployeToProjet(@RequestParam("projetId") Long projetId,@RequestParam("employeId") Long employeId){
        return new ResponseEntity<>(this.projetService.affecterEmployeToProjet(projetId,employeId),HttpStatus.OK);
    }
}
