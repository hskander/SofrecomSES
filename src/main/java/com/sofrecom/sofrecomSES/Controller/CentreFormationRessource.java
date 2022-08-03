package com.sofrecom.sofrecomSES.Controller;

import com.sofrecom.sofrecomSES.Model.CentreFormation;
import com.sofrecom.sofrecomSES.Service.CentreFormationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CentreFormation")
public class CentreFormationRessource {
    private final CentreFormationServiceInterface centreFormationService;
    @Autowired
    public CentreFormationRessource(CentreFormationServiceInterface centreFormationService) {
        this.centreFormationService = centreFormationService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<CentreFormation>> getAllCentresFormation() {
        List<CentreFormation> centresFormation = centreFormationService.getAllCentresFormation();
        return new ResponseEntity<>(centresFormation, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<CentreFormation> getCentreFormationById(@PathVariable("id") Long id) {
        CentreFormation centreFormation = centreFormationService.getCentreFormationById(id);
        return new ResponseEntity<>(centreFormation, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<CentreFormation> addCentreFormation(@RequestBody CentreFormation centreFormation) {
       CentreFormation newcentreFormation = centreFormationService.addCentreFormation(centreFormation);
        return new ResponseEntity<>(newcentreFormation, HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<CentreFormation> updateCentreFormation(@RequestBody CentreFormation centreFormation) {
        CentreFormation updateCentreFormation= centreFormationService.updateCentreFormation(centreFormation);
        return new ResponseEntity<>(updateCentreFormation, HttpStatus.OK);


    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deleteCentreFormation(@PathVariable("id") Long id) {
        centreFormationService.deleteCentreFormation(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
