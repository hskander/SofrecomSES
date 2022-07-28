package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Model.Certificat;
import com.sofrecom.sofrecomSES.Model.Diplome;
import com.sofrecom.sofrecomSES.Model.Employe;
import com.sofrecom.sofrecomSES.Model.Experience;

import java.util.List;

public interface EmployeServiceInterface {
     /*Employe addEmployee(Employe e, Long posteId, Long poleId,
                         List<Experience> experiences, List<Diplome> diplomes, List<Certificat> certificats,
                         Long entrepriseId, Long institutId, Long cfId);*/
    List<Employe> getAllEmployees();
    Employe getEmployeByMatricule(Long id);
    Employe updateEmployee(Employe e);
    void deleteEmployee(Long id);
}
