package com.sofrecom.sofrecomSES.Controller;

import com.sofrecom.sofrecomSES.Service.CertificatServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Certificat")
public class CertificatRessource {
    private final CertificatServiceInterface certificatService;
    @Autowired
    public CertificatRessource(CertificatServiceInterface certificatService) {
        this.certificatService = certificatService;
    }
}
