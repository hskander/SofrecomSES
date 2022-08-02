package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Model.*;

import java.util.List;

public interface EmployeServiceInterface {
    List<Employe> getAllEmployees();
    Employe getEmployeById(Long id);
    Employe updateEmployee(Employe e);
    void deleteEmployee(Long id);
}
