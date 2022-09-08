package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Model.Pole;
import com.sofrecom.sofrecomSES.Model.Employe;

import java.util.List;

public interface PoleServiceInterface {
    List<Pole> getAllPoles();
    Pole getPoleById(Long id);
    void deletePole(Long id);
    Pole addPole(Pole pole, Long DirectionId);
    Pole affecterManagerPole(Long poleId,Long EmployeeId);
    Pole editPole(Pole pole);
}
