package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Model.CertificatDetails;

import java.util.Optional;

public interface CertificatDetailsServiceInterface {
    void deleteCertificatDetails(Long id);

    CertificatDetails addCertificatDetails(CertificatDetails certificatDetails, Long idCertificat,Long idCentreFormation,Long employeId);
    CertificatDetails updateCertificatDetails(CertificatDetails certifDetail , Long employeId);

}
