package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Model.Diplome;

import java.util.List;

public interface DiplomeServiceInterface {
    Diplome addDiplome(Diplome diplome);
    List<Diplome> getAllDiplomes();
    Diplome getDiplomeById(Long id);
    Diplome updateDiplome( Diplome diplome);
    void  deleteDiplome(Long id);
}