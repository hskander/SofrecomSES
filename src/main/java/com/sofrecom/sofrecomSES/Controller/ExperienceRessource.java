package com.sofrecom.sofrecomSES.Controller;

import com.sofrecom.sofrecomSES.Model.Experience;
import com.sofrecom.sofrecomSES.Service.ExperienceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Experience")
public class ExperienceRessource {
    private final ExperienceServiceInterface experienceService;
    @Autowired
    public ExperienceRessource(ExperienceServiceInterface experienceService) {
        this.experienceService = experienceService;
    }

    @PostMapping("/addExperience")
    public ResponseEntity<Experience> addExperience(@RequestBody Experience experience, @RequestParam("entrepriseMatricule") Long entrepriseMatricule){
        return new ResponseEntity<> (this.experienceService.addExperience(experience,entrepriseMatricule), HttpStatus.CREATED);
    }
}
