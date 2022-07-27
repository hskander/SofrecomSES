package com.sofrecom.sofrecomSES.Controller;

import com.sofrecom.sofrecomSES.Service.ExperienceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Experience")
public class ExperienceRessource {
    private final ExperienceServiceInterface experienceService;
    @Autowired
    public ExperienceRessource(ExperienceServiceInterface experienceService) {
        this.experienceService = experienceService;
    }
}
