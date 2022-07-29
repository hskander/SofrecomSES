package com.sofrecom.sofrecomSES.Repository;

import com.sofrecom.sofrecomSES.Model.DiplomeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface DiplomeDetailsRepository extends JpaRepository<DiplomeDetails,Long> {
    void deleteDiplomeDetailById(Long id);

}
