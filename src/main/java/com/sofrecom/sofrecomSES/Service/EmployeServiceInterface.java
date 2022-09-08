package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Model.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeServiceInterface {
    Employe addEmployee(Employe employe, Long posteId, Long poleId);
    Employe AffecterDiplomeEmployee(DiplomeDetails diplomeDetails,Long employeId,Long diplomeId, Long institutId);
    Employe AffecterCertificatEmployee(CertificatDetails certificatDetails,Long employeId,Long certificatId,Long centreFormationId);
    Employe AffecterExperienceEmployee(Experience experience,Long employeId,Long entrepriseId);
    List<Employe> getAllEmployees();
    Employe getEmployeById(Long id);
    Employe updateEmployee(Employe e);
    Employe editEmployeePole(Long employeeId,Long  poleId);
    void deleteEmployee(Long id);
    Pole findEmployePole(Long id);
    public Employe findEmployeDirectionManager(Long emlpoyeId);
    List<Employe> findEmployeesByNomPrenomEmail(String nomPrenom);
    List<Employe> findEmployeesByPoste(String poste);
    List<Employe> findEmployeesByCentreFormation(Long centreFormationId);
    List<Employe> findEmployeesByCertificat(Long certificatId);
    List<Employe> findEmployeesByInstitut(Long institutId);
    List<Employe> findEmployeesByDiplome(Long diplomeId);
    List<Employe> findEmployeesByEntreprise(Long entrepriseId);
    List<Employe> findMales(Genre genre);
    List<Employe> findFemales(Genre genre);
    List<Employe> findCelibataire(SituationFamilale genre);
    List<Employe> findMarie(SituationFamilale genre);
    List<Employe> findEmployeByYearRecrut(@Param("year") int year);
    List<Employe> findEmployeByYearDepart(@Param("year") int year);
}
