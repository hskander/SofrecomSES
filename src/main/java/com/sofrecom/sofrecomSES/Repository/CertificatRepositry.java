package com.sofrecom.sofrecomSES.Repository;

import com.sofrecom.sofrecomSES.Model.Certificat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface CertificatRepositry extends JpaRepository<Certificat,Long> {
    void deleteCertificatById(Long id);
    Optional<Certificat> findCertificatById(Long id);
}
