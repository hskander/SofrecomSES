package com.sofrecom.sofrecomSES.Controller;

import com.sofrecom.sofrecomSES.Model.Experience;
import com.sofrecom.sofrecomSES.Model.Poste;
import com.sofrecom.sofrecomSES.Service.ExperienceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Experience")
public class ExperienceRessource {
    private final ExperienceServiceInterface experienceService;
    @Autowired
    public ExperienceRessource(ExperienceServiceInterface experienceService) {
        this.experienceService = experienceService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Experience>> getAllExperiences() {
        List<Experience> experiences = experienceService.findAllExperience();
        return new ResponseEntity<>(experiences, HttpStatus.OK);
    }

    @PostMapping("/addExperience")
    public ResponseEntity<Experience> addExperience(@RequestBody Experience experience, @RequestParam("entrepriseMatricule") Long entrepriseMatricule){
        return new ResponseEntity<> (this.experienceService.addExperience(experience,entrepriseMatricule), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Experience> updateExperience(@RequestBody Experience experience){
        Experience updateExperience = experienceService.updateExperience(experience);
        return new ResponseEntity<>(updateExperience, HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteExperience(@PathVariable("id") Long id){
        experienceService.deleteExperience(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
