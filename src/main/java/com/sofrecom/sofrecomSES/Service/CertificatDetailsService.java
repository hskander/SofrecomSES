package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Repository.CertificatDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CertificatDetailsService implements CertificatDetailsServiceInterface{
    private final CertificatDetailsRepository certificatDetailsRepository;
    @Autowired
    public CertificatDetailsService(CertificatDetailsRepository certificatDetailsRepository) {
        this.certificatDetailsRepository = certificatDetailsRepository;
    }
}
