package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Model.Poste;
import com.sofrecom.sofrecomSES.Repository.PosteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PosteService implements PosteServiceInterface {
    private final PosteRepository posteRepository;
    @Autowired
    public PosteService(PosteRepository posteRepository) {
        this.posteRepository = posteRepository;
    }

    @Override
    public Poste addPoste(Poste poste) {
        return this.posteRepository.save(poste);
    }
}
