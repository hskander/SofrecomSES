package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Model.Experience;

public interface ExperienceServiceInterface {
    Experience addExperience(Experience experience, Long entrepriseId, Long employeeId);
}
