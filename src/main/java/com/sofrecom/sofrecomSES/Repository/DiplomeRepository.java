package com.sofrecom.sofrecomSES.Repository;

import com.sofrecom.sofrecomSES.Model.Diplome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface DiplomeRepository extends JpaRepository<Diplome,Long> {
    void deleteDiplomeById(Long id);
    Optional<Diplome> findDiplomeById(Long id);
}
