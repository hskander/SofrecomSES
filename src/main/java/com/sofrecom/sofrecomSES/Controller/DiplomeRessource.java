package com.sofrecom.sofrecomSES.Controller;

import com.sofrecom.sofrecomSES.Model.Diplome;
import com.sofrecom.sofrecomSES.Service.DiplomeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Diplome")
public class DiplomeRessource {
    private final DiplomeServiceInterface diplomeService;
    @Autowired
    public DiplomeRessource(DiplomeServiceInterface diplomeService) {
        this.diplomeService = diplomeService;
    }

    @PostMapping("/addDiplome")
    public ResponseEntity<Diplome> addDiplome(@RequestBody Diplome diplome,@RequestParam("institutMatricule") Long institutMatricule){
        return new ResponseEntity<> (this.diplomeService.addDiplome(diplome,institutMatricule),HttpStatus.CREATED);
    }
}
