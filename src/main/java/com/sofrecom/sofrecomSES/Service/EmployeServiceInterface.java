package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Model.*;

import java.util.List;

public interface EmployeServiceInterface {
    Employe addEmployee(Employe employe, Long posteId, Long poleId);
    Employe AffecterDiplomeEmployee(DiplomeDetails diplomeDetails,Long employeId,Long diplomeId, Long institutId);
    Employe AffecterCertificatEmployee(CertificatDetails certificatDetails,Long employeId,Long certificatId,Long centreFormationId);
    Employe AffecterExperienceEmployee(Experience experience,Long employeId,Long entrepriseId);
    List<Employe> getAllEmployees();
    Employe getEmployeById(Long id);
    Employe updateEmployee(Employe e);
    void deleteEmployee(Long id);
    Employe findEmployePoleManager(Long emlpoyeId);
    public Employe findEmployeDirectionManager(Long emlpoyeId);
}
