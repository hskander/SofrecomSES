package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService implements ExperienceServiceInterface {
    private final ExperienceRepository experienceRepository;
    @Autowired
    public ExperienceService(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }
}
