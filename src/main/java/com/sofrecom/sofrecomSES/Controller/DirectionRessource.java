package com.sofrecom.sofrecomSES.Controller;

import com.sofrecom.sofrecomSES.Model.Employe;
import com.sofrecom.sofrecomSES.Service.DirectionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Direction")
public class DirectionRessource {
    private final DirectionServiceInterface directionService;
    @Autowired
    public DirectionRessource(DirectionServiceInterface directionService) {
        this.directionService = directionService;
    }
    @GetMapping("/findEmployeesDirection")
    public ResponseEntity<List<Employe>> findEmployeesDirection(@RequestParam("directionId") Long directionId){
        return new ResponseEntity<>(this.directionService.findEmployeesDirection(directionId), HttpStatus.OK);
    }
}
