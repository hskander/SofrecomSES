package com.sofrecom.sofrecomSES.Repository;

import com.sofrecom.sofrecomSES.Model.CentreFormation;
import com.sofrecom.sofrecomSES.Model.CertificatDetails;
import com.sofrecom.sofrecomSES.Model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CertificatDetailsRepository extends JpaRepository<CertificatDetails,Long> {
    @Query("SELECT cd.employe FROM CertificatDetails cd WHERE cd.centreFormation=:centreFormation")
    List<Employe> findEmployeesByCentreFormation(@Param("centreFormation") CentreFormation centreFormation);
}
