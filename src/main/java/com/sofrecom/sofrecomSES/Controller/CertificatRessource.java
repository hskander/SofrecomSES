package com.sofrecom.sofrecomSES.Controller;

import com.sofrecom.sofrecomSES.Model.Certificat;
import com.sofrecom.sofrecomSES.Service.CertificatServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Certificat")
public class CertificatRessource {
    private final CertificatServiceInterface certificatService;
    @Autowired
    public CertificatRessource(CertificatServiceInterface certificatService) {
        this.certificatService = certificatService;
    }

    @PostMapping("/addCertificat")
    public ResponseEntity<Certificat> addCertificat(@RequestBody Certificat certificat, @RequestParam("cfMatricule") Long cfMatricule){
        return new ResponseEntity<> (this.certificatService.addCertificat(certificat,cfMatricule), HttpStatus.CREATED);
    }
}
