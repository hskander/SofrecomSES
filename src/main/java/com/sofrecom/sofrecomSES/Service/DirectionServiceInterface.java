package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Model.Employe;

import java.util.List;

public interface DirectionServiceInterface {
    Employe findDirectionManager(Long directionId);
    List<Employe> findEmployeesDirection(Long directionId);
}
