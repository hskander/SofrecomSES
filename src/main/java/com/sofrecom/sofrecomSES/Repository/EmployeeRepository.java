package com.sofrecom.sofrecomSES.Repository;

import com.sofrecom.sofrecomSES.Model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employe,Long> {
    void deleteEmployeById(Long id);
    Optional<Employe> findEmployeById(Long id);

    @Query("SELECT e FROM Employe e WHERE e.nom LIKE %:nomPrenom% or e.prenom LIKE %:nomPrenom% or e.mail LIKE %:nomPrenom%")
    List<Employe> findEmployeesByNomPrenomEmail(@Param("nomPrenom")String nomPrenom);
    @Query("SELECT e fROM Employe e where e.poste.poste LIKE %:poste% ")
    List<Employe> findEmployeesByPoste(@Param("poste") String poste);

}
