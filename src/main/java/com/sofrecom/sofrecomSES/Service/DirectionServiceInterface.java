package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Model.Direction;
import com.sofrecom.sofrecomSES.Model.Employe;

import java.util.List;

public interface DirectionServiceInterface {

    List<Direction> getAllDirections();

    Direction updateDirection(Direction direction);

    Direction getDirectionById(Long id);

    void deleteDirection(Long id);

    Direction addDirection(Direction direction);
    Direction affecterManagerDirection(Long directionId,Long employeId);
    Employe findDirectionManager(Long directionId);
    List<Employe> findEmployeesDirection(Long directionId);

    Direction findDirectionByManager(Long id);
}
