package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Model.Experience;

import java.util.List;

public interface ExperienceServiceInterface {
    Experience updateExperience(Experience experience);
    void deleteExperience(Long id);
    List<Experience> findAllExperience();
    Experience addExperience(Experience experience, Long entrepriseId, Long employeeId);
}
