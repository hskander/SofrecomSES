package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Exeption.UserNotFoundException;
import com.sofrecom.sofrecomSES.Model.Employe;
import com.sofrecom.sofrecomSES.Model.Projet;
import com.sofrecom.sofrecomSES.Repository.EmployeeRepository;
import com.sofrecom.sofrecomSES.Repository.PosteRepository;
import com.sofrecom.sofrecomSES.Repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetService implements ProjetServiceInterface {
    private final ProjetRepository projetRepository;
    private final EmployeeRepository employeeRepository;
    @Autowired
    public ProjetService(ProjetRepository projetRepository,EmployeeRepository employeeRepository) {
        this.projetRepository = projetRepository;
        this.employeeRepository=employeeRepository;
    }

    @Override
    public Projet addProjet(Projet projet) {
        return this.projetRepository.save(projet);
    }

    @Override
    public List<Projet> getAllProjets() {
        return this.projetRepository.findAll();
    }

    @Override
    public Projet getProjetById(Long id) {
        return this.projetRepository.findProjetById(id).
                orElseThrow(()->new UserNotFoundException("Projet with ID "+id+" was not found" ));
    }

    @Override
    public Projet updateProjet(Projet projet) {
        return this.projetRepository.save(projet);
    }

    @Override
    public void deleteProjet(Long id) {
        this.projetRepository.deleteProjetById(id);
    }

    @Override
    public Projet affecterEmployeToProjet(Long projetId, Long employeId) {
        Projet projet = this.projetRepository.findProjetById(projetId).
                orElseThrow(()->new UserNotFoundException("Projet with ID "+projetId+" was not found" ));
        Employe employe = this.employeeRepository.findEmployeById(employeId).
                orElseThrow(()->new UserNotFoundException("Employe with ID "+employeId+" was not found" ));
        employe.getProjets().add(projet);
        this.employeeRepository.save(employe);
        return projet;
    }
}
