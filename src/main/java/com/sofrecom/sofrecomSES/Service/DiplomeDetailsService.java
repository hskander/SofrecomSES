package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Exeption.UserNotFoundException;
import com.sofrecom.sofrecomSES.Model.*;
import com.sofrecom.sofrecomSES.Repository.DiplomeDetailsRepository;
import com.sofrecom.sofrecomSES.Repository.DiplomeRepository;
import com.sofrecom.sofrecomSES.Repository.EmployeeRepository;
import com.sofrecom.sofrecomSES.Repository.InstitutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class DiplomeDetailsService implements DiplomeDetailsServiceInterface {
    private final DiplomeDetailsRepository diplomeDetailsRepository;
    private final DiplomeRepository diplomeRepository;
    private final InstitutRepository institutRepository;
    private final EmployeeRepository employeeRepository;
    @Autowired
    public DiplomeDetailsService(DiplomeDetailsRepository diplomeDetailsRepository,
                                 DiplomeRepository diplomeRepository,InstitutRepository institutRepository,
                                 EmployeeRepository employeeRepository) {
        this.diplomeDetailsRepository = diplomeDetailsRepository;
        this.diplomeRepository=diplomeRepository;
        this.institutRepository=institutRepository;
        this.employeeRepository=employeeRepository;
    }
    @Override
    public DiplomeDetails addDiplomeDetails(DiplomeDetails diplomeDetails, Long idDiplome,Long idInstitut,Long employeId){
        Diplome diplome=this.diplomeRepository.findDiplomeById(idDiplome).
                orElseThrow(()->new UserNotFoundException("User with ID "+idDiplome+" was not found" ));

        Institut institut = this.institutRepository.findInstitutById(idInstitut).
                orElseThrow(()->new UserNotFoundException("User with ID "+idInstitut+" was not found" ));
        Employe employe = this.employeeRepository.findEmployeById(employeId)
                .orElseThrow(()->new UserNotFoundException("Employe with ID "+employeId+" was not found" ));
        diplomeDetails.setDiplome(diplome);
        diplomeDetails.setInstitut(institut);
        diplomeDetails.setEmploye(employe);
        return this.diplomeDetailsRepository.save(diplomeDetails);
    }

    public DiplomeDetails updateDiplomeDetails(DiplomeDetails diplomeDetail){
        return diplomeDetailsRepository.save(diplomeDetail);
    }

    public void deleteDiplomeDetails(Long id) {
        diplomeDetailsRepository.deleteDiplomeDetailById(id);
    }
}
