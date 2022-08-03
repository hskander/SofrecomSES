package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Model.Experience;

import java.util.List;

public interface ExperienceServiceInterface {
    Experience addExperience(Experience experience, Long entrepriseId);

    Experience updateExperience(Experience experience);
    void deleteExperience(Long id);
    List<Experience> findAllExperience();
}
