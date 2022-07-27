package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Repository.PosteRepository;
import com.sofrecom.sofrecomSES.Repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjetService implements ProjetServiceInterface {
    private final ProjetRepository projetRepository;
    @Autowired
    public ProjetService(ProjetRepository projetRepository) {
        this.projetRepository = projetRepository;
    }
}
