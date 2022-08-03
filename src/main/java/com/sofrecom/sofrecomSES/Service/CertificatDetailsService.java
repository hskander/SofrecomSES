package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Exeption.UserNotFoundException;
import com.sofrecom.sofrecomSES.Model.CentreFormation;
import com.sofrecom.sofrecomSES.Model.Certificat;
import com.sofrecom.sofrecomSES.Model.CertificatDetails;
import com.sofrecom.sofrecomSES.Repository.CentreFormationRepository;
import com.sofrecom.sofrecomSES.Repository.CertificatDetailsRepository;
import com.sofrecom.sofrecomSES.Repository.CertificatRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CertificatDetailsService implements CertificatDetailsServiceInterface{
    private final CertificatDetailsRepository certificatDetailsRepository;
    private final CertificatRepositry certificatRepositry;
    private final CentreFormationRepository cfRepo;
    @Autowired
    public CertificatDetailsService(CertificatDetailsRepository certificatDetailsRepository,
                                    CertificatRepositry certificatRepositry,CentreFormationRepository cfRepo) {
        this.certificatDetailsRepository = certificatDetailsRepository;
        this.certificatRepositry=certificatRepositry;
        this.cfRepo=cfRepo;
    }

    public CertificatDetails addCertificatDetails(CertificatDetails certificatDetails, Long idCertificat,Long idCentreFormation){
        Certificat certificat = this.certificatRepositry.findCertificatById(idCertificat).
                orElseThrow(()->new UserNotFoundException("User with ID "+idCertificat+" was not found" ));

        CentreFormation centreFormation = this.cfRepo.findCentreFormationById(idCentreFormation).
                orElseThrow(()->new UserNotFoundException("User with ID "+idCentreFormation+" was not found" ));

        certificatDetails.setCertificat(certificat);
        certificatDetails.setCentreFormation(centreFormation);

        return this.certificatDetailsRepository.save(certificatDetails);

    }

    public CertificatDetails updateCertificatDetails(CertificatDetails certifDetail){
        return certificatDetailsRepository.save(certifDetail);
    }

    public void deleteCertificatDetails(Long id) {
        certificatDetailsRepository.deleteCertificatDetailsById(id);
    }




}
