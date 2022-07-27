package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Model.Employe;

import java.util.List;

public interface EmployeServiceInterface {
     Employe addEmployee(Employe e);
    List<Employe> getAllEmployees();
    Employe getEmployeByMatricule(Long id);
    Employe updateEmployee(Employe e);
    void deleteEmployee(Long id);
}
