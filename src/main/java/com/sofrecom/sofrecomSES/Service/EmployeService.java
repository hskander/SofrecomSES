package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Exeption.UserNotFoundException;
import com.sofrecom.sofrecomSES.Model.*;
import com.sofrecom.sofrecomSES.Repository.EmployeeRepository;
import com.sofrecom.sofrecomSES.Repository.PoleRepository;
import com.sofrecom.sofrecomSES.Repository.PosteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeService implements EmployeServiceInterface {
    //Repositories
    private final EmployeeRepository employeeRepo;
    private final PoleRepository poleRepo;
    private final PosteRepository posteRepo;

    //Services
   private final ExperienceServiceInterface experienceService;
    private final DiplomeDetailsServiceInterface diplomeDetailsService;
    private final CertificatDetailsServiceInterface certificatDetailsService;
    //private final PoleServiceInterface poleService;
    @Autowired
    public EmployeService(EmployeeRepository employeeRepo,PoleRepository poleRepo,PosteRepository posteRepo,
                          ExperienceServiceInterface experienceService, DiplomeDetailsServiceInterface diplomeDetailsService, CertificatDetailsServiceInterface certificatDetailsService
                          /*PoleServiceInterface poleService*/) {
        this.employeeRepo = employeeRepo;
        this.poleRepo=poleRepo;
        this.posteRepo=posteRepo;

        this.experienceService=experienceService;
        this.certificatDetailsService=certificatDetailsService;
        this.diplomeDetailsService=diplomeDetailsService;
        //this.poleService=poleService;
    }

    public Employe addEmployee(Employe employe, Long posteId, Long poleId){

        Pole pole = this.poleRepo.findPoleById(poleId).
                orElseThrow(()->new UserNotFoundException("Pole with ID "+poleId+" was not found" ));
        Poste poste= this.posteRepo.findPosteById(posteId).
                orElseThrow(()->new UserNotFoundException("Poste with ID "+posteId+" was not found" ));
        employe.setPole(pole);
        employe.setPoste(poste);
        employe.setEmployeCode(UUID.randomUUID().toString());

        return this.employeeRepo.save(employe);
    }
    public Employe AffecterDiplomeEmployee(DiplomeDetails diplomeDetails,Long employeId,Long diplomeId, Long institutId){

        Employe employe=this.employeeRepo.findEmployeById(employeId).
                orElseThrow(()->new UserNotFoundException("Employe with ID "+employeId+" was not found" ));
        employe.getListDiplomeDetails().add(this.diplomeDetailsService.addDiplomeDetails(diplomeDetails,diplomeId,institutId));
        return this.employeeRepo.save(employe);

    }
    public Employe AffecterCertificatEmployee(CertificatDetails certificatDetails,Long employeId,Long certificatId,Long centreFormationId){
        Employe employe=this.employeeRepo.findEmployeById(employeId).
                orElseThrow(()->new UserNotFoundException("Employe with ID "+employeId+" was not found" ));
        employe.getListCertificatDetails().add(this.certificatDetailsService.addCertificatDetails(certificatDetails,certificatId,centreFormationId));
        return this.employeeRepo.save(employe);

    }

    public Employe AffecterExperienceEmployee(Experience experience,Long employeId,Long entrepriseId){
        Employe employe=this.employeeRepo.findEmployeById(employeId).
                orElseThrow(()->new UserNotFoundException("Employe with ID "+employeId+" was not found" ));
        employe.getExperiences().add(this.experienceService.addExperience(experience,entrepriseId));
       return  this.employeeRepo.save(employe);

    }

    public List<Employe> getAllEmployees(){
        return this.employeeRepo.findAll();
    }

    public Employe getEmployeById(Long id){
        return this.employeeRepo.findEmployeById(id)
                .orElseThrow(()->new UserNotFoundException("Employe with ID "+id+" was not found" ));
    }

    public Employe updateEmployee(Employe e){

        return this.employeeRepo.save(e);
    }

    public void deleteEmployee(Long id){
        this.employeeRepo.deleteEmployeById(id);
    }

    public Employe findEmployePoleManager(Long emlpoyeId){
        Employe employe =this.employeeRepo.findEmployeById(emlpoyeId)
                .orElseThrow(()->new UserNotFoundException("Employe with ID "+emlpoyeId+" was not found" ));
        return employe.getPole().getManager();
    }
    public Employe findEmployeDirectionManager(Long emlpoyeId){
        Employe employe =this.employeeRepo.findEmployeById(emlpoyeId)
                .orElseThrow(()->new UserNotFoundException("Employe with ID "+emlpoyeId+" was not found" ));
        return employe.getPole().getDirection().getManager();
    }


}
