package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Repository.PoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PoleService implements PoleServiceInterface {
    private final PoleRepository poleRepository;
    @Autowired
    public PoleService(PoleRepository poleRepository) {
        this.poleRepository = poleRepository;
    }
}
