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
   /* private final ExperienceService experienceService;
    private final DiplomeDetailsService diplomeDetailsService;
    private final CertificatDetailsService certificatDetailsService;*/
    @Autowired
    public EmployeService(EmployeeRepository employeeRepo,PoleRepository poleRepo,PosteRepository posteRepo,
                          ExperienceService experienceService, DiplomeDetailsService diplomeDetailsService, CertificatDetailsService certificatDetailsService) {
        this.employeeRepo = employeeRepo;
        this.poleRepo=poleRepo;
        this.posteRepo=posteRepo;

        /*this.experienceService=experienceService;
        this.certificatDetailsService=certificatDetailsService;
        this.diplomeDetailsService=diplomeDetailsService;*/
    }

    public Employe addEmployee(Employe employe, Long posteId, Long poleId,
                               List<Experience> experiences, List<DiplomeDetails> ListDiplomeDetails,
                               List<CertificatDetails> ListCertificatDetails
                               ){

        Pole pole = this.poleRepo.findPoleById(poleId).
                orElseThrow(()->new UserNotFoundException("User with ID "+poleId+" was not found" ));
        Poste poste= this.posteRepo.findPosteById(posteId).
                orElseThrow(()->new UserNotFoundException("User with ID "+posteId+" was not found" ));
        employe.setPole(pole);
        employe.setPoste(poste);
        for(Experience experience :experiences){
            employe.getExperiences().add(experience);
        }
        for(DiplomeDetails dd :ListDiplomeDetails){
            employe.getListDiplomeDetails().add(dd);
        }
        for(CertificatDetails cd :ListCertificatDetails){
            employe.getListCertificatDetails().add(cd);
        }
        employe.setEmployeCode(UUID.randomUUID().toString());

        return this.employeeRepo.save(employe);
    }

    public List<Employe> getAllEmployees(){
        return this.employeeRepo.findAll();
    }

    public Employe getEmployeById(Long id){
        return this.employeeRepo.findEmployeById(id)
                .orElseThrow(()->new UserNotFoundException("User with ID "+id+" was not found" ));
    }

    public Employe updateEmployee(Employe e){

        return this.employeeRepo.save(e);
    }

    public void deleteEmployee(Long id){
        this.employeeRepo.deleteEmployeById(id);
    }


}
