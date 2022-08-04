package com.sofrecom.sofrecomSES.Controller;

import com.sofrecom.sofrecomSES.Model.Diplome;
import com.sofrecom.sofrecomSES.Service.DiplomeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Diplome")
public class DiplomeRessource {
    private final DiplomeServiceInterface diplomeService;
    @Autowired
    public DiplomeRessource(DiplomeServiceInterface diplomeService) {
        this.diplomeService = diplomeService;
    }

    @PostMapping("/addDiplome")
    public ResponseEntity<Diplome> addDiplome(@RequestBody Diplome diplome){
        return new ResponseEntity<> (this.diplomeService.addDiplome(diplome),HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Diplome>> getAllDiplomes() {
        List<Diplome> diplomes = diplomeService.getAllDiplomes();
        return new ResponseEntity<>(diplomes, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Diplome> getDiplomeById(@PathVariable("id") Long id) {
        Diplome diplome= diplomeService.getDiplomeById(id);
        return new ResponseEntity<>(diplome, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Diplome> UpdateDiplome(@RequestBody Diplome diplome) {
        Diplome updateDiplome = diplomeService.updateDiplome(diplome);
        return new ResponseEntity<>(updateDiplome, HttpStatus.OK);
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deleteDiplome(@PathVariable("id") Long id) {
        diplomeService.deleteDiplome(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}