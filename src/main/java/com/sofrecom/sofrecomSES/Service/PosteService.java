package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Model.Employe;
import com.sofrecom.sofrecomSES.Model.Poste;
import com.sofrecom.sofrecomSES.Repository.EmployeeRepository;
import com.sofrecom.sofrecomSES.Repository.PosteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PosteService implements PosteServiceInterface {
    private final PosteRepository posteRepository;
    private final EmployeeRepository employeeRepository;
    @Autowired
    public PosteService(PosteRepository posteRepository,EmployeeRepository employeeRepository) {
        this.employeeRepository=employeeRepository;
        this.posteRepository = posteRepository;
    }

    @Override
    public Poste addPoste(Poste poste){
        return posteRepository.save(poste);
    }

    @Override
    public List<Poste> findAllPostes(){
        return posteRepository.findAll();
    }

    @Override
    public Poste updatePoste(Poste poste){
        return posteRepository.save(poste);
    }

    @Override
    public void deletePoste(Long id) {
        List<Employe> employeesWithThatJob = this.employeeRepository.employeesByIdPoste(id);
        for(Employe e:employeesWithThatJob){
            e.setPoste(null);
        }
        posteRepository.deletePosteById(id);
    }
}
