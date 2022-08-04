package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Model.Pole;

import java.util.List;

public interface PoleServiceInterface {

    List<Pole> getAllPoles();
    Pole getPoleById(Long id);
    void deletePole(Long id);
    Pole addPole(Pole pole, Long DirectionId,Long EmployeeId);
    Pole editPole(Pole pole);
}
