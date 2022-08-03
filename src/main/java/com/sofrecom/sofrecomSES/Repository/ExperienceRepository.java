package com.sofrecom.sofrecomSES.Repository;

import com.sofrecom.sofrecomSES.Model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ExperienceRepository extends JpaRepository<Experience,Long> {
    void deleteExperienceById(Long id);
}
