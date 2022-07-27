package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Repository.CertificatRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CertificatService implements CertificatServiceInterface {
    private final CertificatRepositry certificatRepository;
    @Autowired
    public CertificatService(CertificatRepositry certificatRepository) {
        this.certificatRepository = certificatRepository;
    }
}
