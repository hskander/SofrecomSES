package com.sofrecom.sofrecomSES.Repository;

import com.sofrecom.sofrecomSES.Model.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface EntrepriseRepository extends JpaRepository<Entreprise,Long> {
    void deleteEntrepriseById(Long id);
    Optional<Entreprise> findEntrepriseById(Long id);
}
