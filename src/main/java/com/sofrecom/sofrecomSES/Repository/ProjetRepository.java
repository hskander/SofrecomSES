package com.sofrecom.sofrecomSES.Repository;

import com.sofrecom.sofrecomSES.Model.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface ProjetRepository extends JpaRepository<Projet,Long> {
    void deleteProjetById(Long id);
    Optional<Projet> findProjetById(Long id);
}
