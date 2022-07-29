package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Model.Poste;

import java.util.List;

public interface PosteServiceInterface {
    Poste addPoste(Poste poste);

    Poste updatePoste(Poste poste);

    List<Poste> findAllPostes();

    void deletePoste(Long id);
}
