package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Model.Poste;
import com.sofrecom.sofrecomSES.Repository.PosteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PosteService implements PosteServiceInterface {
    private final PosteRepository posteRepository;
    @Autowired
    public PosteService(PosteRepository posteRepository) {
        this.posteRepository = posteRepository;
    }
    public Poste addPoste(Poste poste){
        return posteRepository.save(poste);
    }

    public List<Poste> findAllPostes(){
        return posteRepository.findAll();
    }

    public Poste updatePoste(Poste poste){
        return posteRepository.save(poste);
    }

    public void deletePoste(Long id) {
        posteRepository.deletePosteById(id);
    }

}
