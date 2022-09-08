package com.sofrecom.sofrecomSES.Controller;

import com.sofrecom.sofrecomSES.Model.Certificat;
import com.sofrecom.sofrecomSES.Model.Poste;
import com.sofrecom.sofrecomSES.Service.CertificatServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Certificat")
public class CertificatRessource {
    private final CertificatServiceInterface certificatService;
    @Autowired
    public CertificatRessource(CertificatServiceInterface certificatService) {
        this.certificatService = certificatService;
    }

    @PostMapping("/addCertificat")
    public ResponseEntity<Certificat> addCertificat(@RequestBody Certificat certificat){
        return new ResponseEntity<> (this.certificatService.addCertificat(certificat), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Certificat>> getAllCertificat() {
        List<Certificat> certificats = certificatService.findAllCertificat();
        return new ResponseEntity<>(certificats, HttpStatus.OK);
    }


    @PutMapping("/update")
    public ResponseEntity<Certificat> updateCertificat(@RequestBody Certificat certificat){
        Certificat updateCertificat = certificatService.updateCertificat(certificat);
        return new ResponseEntity<>(updateCertificat, HttpStatus.OK);

    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCertificat(@RequestParam("id") Long id){
        certificatService.deleteCertificat(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
