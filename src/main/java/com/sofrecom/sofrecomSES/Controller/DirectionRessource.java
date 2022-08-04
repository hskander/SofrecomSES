package com.sofrecom.sofrecomSES.Controller;

import com.sofrecom.sofrecomSES.Model.Direction;
import com.sofrecom.sofrecomSES.Model.Employe;
import com.sofrecom.sofrecomSES.Model.Experience;
import com.sofrecom.sofrecomSES.Service.DirectionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Direction")
public class DirectionRessource {
    private final DirectionServiceInterface directionService;

    @Autowired
    public DirectionRessource(DirectionServiceInterface directionService) {

        this.directionService = directionService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Direction>> getAllDirections() {
        List<Direction> directions = directionService.getAllDirections();
        return new ResponseEntity<>(directions, HttpStatus.OK);
    }

    @GetMapping("/getDirectionById")
    public ResponseEntity<List<Direction>> getDirectionById(@RequestParam("id") Long id) {
        Direction direction = directionService.getDirectionById(id);
        return new ResponseEntity(direction, HttpStatus.OK);
    }


    @PutMapping("/editDirection")
    public ResponseEntity<Direction> updateDirection(@RequestBody Direction direction) {
        return new ResponseEntity<>(this.directionService.updateDirection(direction), HttpStatus.OK);
    }

    @PostMapping("/addDirection")
    public ResponseEntity<Direction> addDirection(@RequestBody Direction direction, @RequestParam("employeId") Long  employeId){
        return new ResponseEntity<> (this.directionService.addDirection(direction,employeId), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteDirection")
    public ResponseEntity<?> deleteDirection(@RequestParam("id") Long id){
        this.directionService.deleteDirection(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}