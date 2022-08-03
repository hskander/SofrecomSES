package com.sofrecom.sofrecomSES.Controller;

import com.sofrecom.sofrecomSES.Model.Employe;
import com.sofrecom.sofrecomSES.Service.PoleServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Pole")
public class PoleRessource {
    private final PoleServiceInterface poleService;
    @Autowired
    public PoleRessource(PoleServiceInterface poleService) {

        this.poleService = poleService;
    }
    @GetMapping("/EmployeesByPole")
    public ResponseEntity<List<Employe>> findEmployeesPole(@RequestParam("poleId") Long poleId){
        return new ResponseEntity<>(this.poleService.findEmployeesPole(poleId), HttpStatus.OK);
    }
}
