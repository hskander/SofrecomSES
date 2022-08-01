package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Model.Employe;

public interface DirectionServiceInterface {
    Employe findDirectionManager(Long directionId);
}
