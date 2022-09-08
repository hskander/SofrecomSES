package com.sofrecom.sofrecomSES.Controller;

import com.sofrecom.sofrecomSES.Model.Institut;
import com.sofrecom.sofrecomSES.Service.InstitutServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Institut")
public class InstitutRessource {
    private final InstitutServiceInterface institutService;
    @Autowired
    public InstitutRessource(InstitutServiceInterface institutService) {
        this.institutService = institutService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Institut>> getAllInstituts() {
        List<Institut> instituts = institutService.getAllInstituts();
        return new ResponseEntity<>(instituts, HttpStatus.OK);

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Institut> getInstitutById(@PathVariable("id") Long id) {
       Institut institut= institutService.getInstitutById(id);
        return new ResponseEntity<>(institut, HttpStatus.OK);

    }

    @PostMapping("/add")
    public ResponseEntity<Institut> addInstitut(@RequestBody Institut institut) {
        Institut newInstitut = institutService.addInstitut(institut);
        return new ResponseEntity<>(newInstitut, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Institut> updateInstitut(@RequestBody Institut institut) {
        Institut updateInsitut = institutService.updateInstitut(institut);
        return new ResponseEntity<>(updateInsitut, HttpStatus.OK);
    }

    @DeleteMapping ("/delete")
    public ResponseEntity<?> deleteInstitut(@RequestParam("id") Long id) {
        institutService.deleteInstitut(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}

