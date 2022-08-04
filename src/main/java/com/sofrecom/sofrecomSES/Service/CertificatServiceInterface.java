package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Model.Certificat;

import java.util.List;

public interface CertificatServiceInterface {
    Certificat addCertificat(Certificat certificat);
    List<Certificat> findAllCertificat();
    Certificat updateCertificat(Certificat certif);

    void deleteCertificat(Long id);
}
