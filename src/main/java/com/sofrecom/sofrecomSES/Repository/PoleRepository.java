package com.sofrecom.sofrecomSES.Repository;

import com.sofrecom.sofrecomSES.Model.Pole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface PoleRepository extends JpaRepository<Pole,Long> {
    void deletePoleById(Long matricule);
    Optional<Pole> findPoleById(Long id);
}
