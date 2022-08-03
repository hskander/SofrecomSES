package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Model.CertificatDetails;

import java.util.Optional;

public interface CertificatDetailsServiceInterface {

    void deleteCertificatDetails(Long id);

    CertificatDetails updateCertificatDetails(CertificatDetails certifDetail);

    CertificatDetails addCertificatDetails(CertificatDetails certificatDetails, Long idCertificat,Long idCentreFormation);
}
