package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Exeption.UserNotFoundException;
import com.sofrecom.sofrecomSES.Model.CentreFormation;
import com.sofrecom.sofrecomSES.Model.Certificat;
import com.sofrecom.sofrecomSES.Repository.CentreFormationRepository;
import com.sofrecom.sofrecomSES.Repository.CertificatRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CertificatService implements CertificatServiceInterface {
    private final CertificatRepositry certificatRepository;
    private final CentreFormationRepository centreFormationRepository;
    @Autowired
    public CertificatService(CertificatRepositry certificatRepository,CentreFormationRepository centreFormationRepository) {
        this.certificatRepository = certificatRepository;
        this.centreFormationRepository=centreFormationRepository;
    }

    public Certificat addCertificat(Certificat certificat, Long centreFormationId){
        CentreFormation centreFormation=this.centreFormationRepository.findCentreFormationById(centreFormationId).
                orElseThrow(()->new UserNotFoundException("User with ID "+centreFormationId+" was not found" ));
        certificat.setCentreFormation(centreFormation);
        return this.certificatRepository.save(certificat);
    }
}
