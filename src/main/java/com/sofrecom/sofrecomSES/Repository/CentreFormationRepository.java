package com.sofrecom.sofrecomSES.Repository;

import com.sofrecom.sofrecomSES.Model.CentreFormation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface CentreFormationRepository extends JpaRepository<CentreFormation,Long> {
    void deleteCentreFormationById(Long id);
    Optional<CentreFormation> findCentreFormationById(Long id);

}
