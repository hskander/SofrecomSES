package com.sofrecom.sofrecomSES.Repository;

import com.sofrecom.sofrecomSES.Model.CentreFormation;
import com.sofrecom.sofrecomSES.Model.Employe;
import com.sofrecom.sofrecomSES.Model.Entreprise;
import com.sofrecom.sofrecomSES.Model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ExperienceRepository extends JpaRepository<Experience,Long> {
<<<<<<< HEAD
    void deleteExperienceById(Long id);
=======
    @Query("SELECT e.employe FROM Experience e WHERE e.entreprise=:entreprise")
    List<Employe> findEmployeesByEntreprise(@Param("entreprise")Entreprise entreprise);
>>>>>>> skanderHAMDI
}
