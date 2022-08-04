package com.sofrecom.sofrecomSES.Controller;

import com.sofrecom.sofrecomSES.Model.Poste;
import com.sofrecom.sofrecomSES.Service.PosteServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Poste")
public class PosteRessource {
    private final PosteServiceInterface posteService;
    @Autowired
    public PosteRessource(PosteServiceInterface posteService) {

        this.posteService = posteService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Poste>> getAllPostes() {
        List<Poste> postes = posteService.findAllPostes();
        return new ResponseEntity<>(postes, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Poste> addPoste(@RequestBody Poste poste){
        Poste newPoste = posteService.addPoste(poste);
        return new ResponseEntity<>(newPoste, HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<Poste> updatePoste(@RequestBody Poste poste){
        Poste updatePoste = posteService.updatePoste(poste);
        return new ResponseEntity<>(updatePoste, HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePoste(@PathVariable("id") Long id){
        posteService.deletePoste(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
