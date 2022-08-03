package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Exeption.UserNotFoundException;
import com.sofrecom.sofrecomSES.Model.Entreprise;
import com.sofrecom.sofrecomSES.Model.Experience;
import com.sofrecom.sofrecomSES.Model.Poste;
import com.sofrecom.sofrecomSES.Repository.EntrepriseRepository;
import com.sofrecom.sofrecomSES.Repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceService implements ExperienceServiceInterface {
    private final ExperienceRepository experienceRepository;
    private final EntrepriseRepository entrepriseRepository;
    @Autowired
    public ExperienceService(ExperienceRepository experienceRepository,EntrepriseRepository entrepriseRepository) {
        this.experienceRepository = experienceRepository;
        this.entrepriseRepository = entrepriseRepository;
    }

    public Experience addExperience(Experience experience, Long entrepriseId){
        Entreprise entreprise=this.entrepriseRepository.findEntrepriseById(entrepriseId).
                orElseThrow(()->new UserNotFoundException("User with ID "+entrepriseId+" was not found" ));
        experience.setEntreprise(entreprise);
        return this.experienceRepository.save(experience);
    }

    public List<Experience> findAllExperience(){
        return experienceRepository.findAll();
    }
    public Experience updateExperience(Experience experience){
        return experienceRepository.save(experience);
    }

    public void deleteExperience(Long id) {
        experienceRepository.deleteExperienceById(id);
    }
}
