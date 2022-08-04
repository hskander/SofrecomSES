package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Exeption.UserNotFoundException;
import com.sofrecom.sofrecomSES.Model.Employe;
import com.sofrecom.sofrecomSES.Model.Entreprise;
import com.sofrecom.sofrecomSES.Model.Experience;
import com.sofrecom.sofrecomSES.Model.Poste;
import com.sofrecom.sofrecomSES.Repository.EmployeeRepository;
import com.sofrecom.sofrecomSES.Repository.EntrepriseRepository;
import com.sofrecom.sofrecomSES.Repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceService implements ExperienceServiceInterface {
    private final ExperienceRepository experienceRepository;
    private final EntrepriseRepository entrepriseRepository;
    private final EmployeeRepository employeeRepository;
    @Autowired
    public ExperienceService(ExperienceRepository experienceRepository,EntrepriseRepository entrepriseRepository,
                             EmployeeRepository employeeRepository) {
        this.experienceRepository = experienceRepository;
        this.entrepriseRepository = entrepriseRepository;
        this.employeeRepository=employeeRepository;
    }
    @Override
    public Experience addExperience(Experience experience, Long entrepriseId,Long employeId){
        Entreprise entreprise=this.entrepriseRepository.findEntrepriseById(entrepriseId).
                orElseThrow(()->new UserNotFoundException("Entreprise with ID "+entrepriseId+" was not found" ));
        Employe employe=this.employeeRepository.findEmployeById(employeId).
                orElseThrow(()->new UserNotFoundException("User with ID "+employeId+" was not found" ));
        experience.setEntreprise(entreprise);
        experience.setEmploye(employe);
        return this.experienceRepository.save(experience);
    }

    @Override
    public List<Experience> findAllExperience(){
        return experienceRepository.findAll();
    }
    @Override
    public Experience updateExperience(Experience experience){
        return experienceRepository.save(experience);
    }
    @Override
    public void deleteExperience(Long id) {
        experienceRepository.deleteExperienceById(id);
    }
}
