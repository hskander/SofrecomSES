package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Exeption.UserNotFoundException;
import com.sofrecom.sofrecomSES.Model.CentreFormation;
import com.sofrecom.sofrecomSES.Model.Certificat;
import com.sofrecom.sofrecomSES.Model.Poste;
import com.sofrecom.sofrecomSES.Repository.CentreFormationRepository;
import com.sofrecom.sofrecomSES.Repository.CertificatRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificatService implements CertificatServiceInterface {
    private final CertificatRepositry certificatRepository;
    private final CentreFormationRepository centreFormationRepository;
    @Autowired
    public CertificatService(CertificatRepositry certificatRepository,CentreFormationRepository centreFormationRepository) {
        this.certificatRepository = certificatRepository;
        this.centreFormationRepository=centreFormationRepository;
    }
    @Override
    public Certificat addCertificat(Certificat certificat){
        return this.certificatRepository.save(certificat);
    }

    public List<Certificat> findAllCertificat(){
        return certificatRepository.findAll();
    }

    public Certificat updateCertificat(Certificat certif){
        return certificatRepository.save(certif);
    }

    public void deleteCertificat(Long id) {
        certificatRepository.deleteCertificatById(id);
    }


}
