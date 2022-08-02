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

    @Autowired
    public EmployeService(EmployeeRepository employeeRepo,PoleRepository poleRepo,PosteRepository posteRepo
                          ) {
        this.employeeRepo = employeeRepo;
        this.poleRepo=poleRepo;
        this.posteRepo=posteRepo;
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
