package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Model.Diplome;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

public interface DiplomeServiceInterface {
    Diplome addDiplome(Diplome diplome);

    List<Diplome> getAllDiplomes();

    Diplome getDiplomeById(Long id);

    Diplome updateDiplome( Diplome diplome);

    void  deleteDiplome(Long id);
}