package com.sofrecom.sofrecomSES.Repository;

import com.sofrecom.sofrecomSES.Model.DiplomeDetails;
import com.sofrecom.sofrecomSES.Model.Employe;
import com.sofrecom.sofrecomSES.Model.Institut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface DiplomeDetailsRepository extends JpaRepository<DiplomeDetails,Long> {
    @Query("SELECT d.employe FROM DiplomeDetails d WHERE d.institut =:institut")
    List<Employe> findEmployeesByInstitut(@Param("institut") Institut institut);
}
