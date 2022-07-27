package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Exeption.UserNotFoundException;
import com.sofrecom.sofrecomSES.Model.Employe;
import com.sofrecom.sofrecomSES.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeService implements EmployeServiceInterface {
    private final EmployeeRepository employeeRepo;
    @Autowired
    public EmployeService(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employe addEmployee(Employe e){
        e.setEmployeCode(UUID.randomUUID().toString());
        return this.employeeRepo.save(e);
    }

    public List<Employe> getAllEmployees(){
        return this.employeeRepo.findAll();
    }

    public Employe getEmployeByMatricule(Long id){
        return this.employeeRepo.findEmployeByMatricule(id)
                .orElseThrow(()->new UserNotFoundException("User with ID "+id+" was not found" ));
    }

    public Employe updateEmployee(Employe e){

        return this.employeeRepo.save(e);
    }

    public void deleteEmployee(Long id){
        this.employeeRepo.deleteEmployeByMatricule(id);
    }


}
