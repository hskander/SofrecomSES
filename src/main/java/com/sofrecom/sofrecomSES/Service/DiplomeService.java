package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Repository.DiplomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiplomeService implements DiplomeServiceInterface {
    private final DiplomeRepository diplomeRepository;
    @Autowired
    public DiplomeService(DiplomeRepository diplomeRepository) {
        this.diplomeRepository = diplomeRepository;
    }
}
