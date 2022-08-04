package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Model.Employe;

import java.util.List;

public interface PoleServiceInterface {
    Employe findPoleManager(Long poleId);
    List<Employe> findEmployeesPole(Long poleId);
}
