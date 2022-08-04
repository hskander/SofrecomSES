package com.sofrecom.sofrecomSES.Controller;

import com.sofrecom.sofrecomSES.Model.Direction;
import com.sofrecom.sofrecomSES.Model.Pole;
import com.sofrecom.sofrecomSES.Service.PoleService;
import com.sofrecom.sofrecomSES.Model.Employe;
import com.sofrecom.sofrecomSES.Service.PoleServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Pole")
public class PoleRessource {
    private final PoleServiceInterface poleService;
    @Autowired
    public PoleRessource(PoleServiceInterface poleService) {

        this.poleService = poleService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Pole>> getAllPoles() {
        List<Pole> poles = poleService.getAllPoles();
        return new ResponseEntity<>(poles, HttpStatus.OK);}


    @GetMapping("/findById")
    public ResponseEntity<Pole> getPoleById(@RequestParam("id") Long id) {
        Pole pole = poleService.getPoleById(id);
        return new ResponseEntity<>(pole, HttpStatus.OK);

    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deletePole(@RequestParam("id") Long id) {
        poleService.deletePole(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/addPole")
    public ResponseEntity<Pole> addPole(@RequestBody Pole pole, @RequestParam("directionId") Long directionId){
        return new ResponseEntity<> (this.poleService.addPole(pole,directionId), HttpStatus.CREATED);
    }
    @PutMapping("/affecterManagerPole")
    public ResponseEntity<Pole> affecterManagerPole(@RequestParam("poleId") Long poleId,@RequestParam("employeId") Long employeId){
        return new ResponseEntity<>(this.poleService.affecterManagerPole(poleId,employeId),HttpStatus.OK);
    }

    @PutMapping("/editPole")
    public ResponseEntity<Pole> editPole(@RequestBody Pole pole){
        return new ResponseEntity<> (this.poleService.editPole(pole), HttpStatus.CREATED);
    }

    @GetMapping("/EmployeesByPole")
    public ResponseEntity<List<Employe>> findEmployeesPole(@RequestParam("poleId") Long poleId){
        return new ResponseEntity<>(this.poleService.findEmployeesPole(poleId), HttpStatus.OK);
    }
}
