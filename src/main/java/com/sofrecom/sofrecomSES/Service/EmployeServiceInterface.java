package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Model.*;

import java.util.List;

public interface EmployeServiceInterface {
    Employe addEmployee(Employe employe, Long posteId, Long poleId,
                        List<Experience> experiences, List<DiplomeDetails> ListDiplomeDetails,
                        List<CertificatDetails> ListCertificatDetails
    );
    List<Employe> getAllEmployees();
    Employe getEmployeById(Long id);
    Employe updateEmployee(Employe e);
    void deleteEmployee(Long id);
}
