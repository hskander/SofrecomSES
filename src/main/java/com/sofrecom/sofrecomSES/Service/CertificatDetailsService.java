package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Exeption.UserNotFoundException;
import com.sofrecom.sofrecomSES.Model.CentreFormation;
import com.sofrecom.sofrecomSES.Model.Certificat;
import com.sofrecom.sofrecomSES.Model.CertificatDetails;
import com.sofrecom.sofrecomSES.Model.Employe;
import com.sofrecom.sofrecomSES.Repository.CentreFormationRepository;
import com.sofrecom.sofrecomSES.Repository.CertificatDetailsRepository;
import com.sofrecom.sofrecomSES.Repository.CertificatRepositry;
import com.sofrecom.sofrecomSES.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CertificatDetailsService implements CertificatDetailsServiceInterface{
    private final CertificatDetailsRepository certificatDetailsRepository;
    private final CertificatRepositry certificatRepositry;
    private final CentreFormationRepository cfRepo;
    private final EmployeeRepository employeeRepository;
    @Autowired
    public CertificatDetailsService(CertificatDetailsRepository certificatDetailsRepository,
                                    CertificatRepositry certificatRepositry,CentreFormationRepository cfRepo,
                                    EmployeeRepository employeeRepository) {
        this.certificatDetailsRepository = certificatDetailsRepository;
        this.certificatRepositry=certificatRepositry;
        this.cfRepo=cfRepo;
        this.employeeRepository=employeeRepository;
    }
    @Override
    public CertificatDetails addCertificatDetails(CertificatDetails certificatDetails, Long idCertificat,Long idCentreFormation,Long employeId){
        Certificat certificat = this.certificatRepositry.findCertificatById(idCertificat).
                orElseThrow(()->new UserNotFoundException("Certificat with ID "+idCertificat+" was not found" ));

        CentreFormation centreFormation = this.cfRepo.findCentreFormationById(idCentreFormation).
                orElseThrow(()->new UserNotFoundException("Centre Formation with ID "+idCentreFormation+" was not found" ));
        Employe employe = this.employeeRepository.findEmployeById(employeId).
                orElseThrow(()->new UserNotFoundException("User with ID "+employeId+" was not found" ));
        certificatDetails.setCertificat(certificat);
        certificatDetails.setCentreFormation(centreFormation);
        certificatDetails.setEmploye(employe);

        return this.certificatDetailsRepository.save(certificatDetails);

    }

    @Override
    public CertificatDetails updateCertificatDetails(CertificatDetails CertifDetails, Long employeId){
        CertifDetails.setEmploye(this.employeeRepository.findEmployeById(employeId)
                .orElseThrow(()->new UserNotFoundException("Employe with ID "+employeId+" was not found" )));
        return certificatDetailsRepository.save(CertifDetails);
    }

    @Override
    public void deleteCertificatDetails(Long id) {
        certificatDetailsRepository.deleteCertificatDetailsById(id);
    }




}
