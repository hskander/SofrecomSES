package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Model.CertificatDetails;

public interface CertificatDetailsServiceInterface {
    CertificatDetails addCertificatDetails(CertificatDetails certificatDetails, Long idCertificat,Long idCentreFormation,Long employeId);
}
