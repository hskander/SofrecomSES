package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Repository.CentreFormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CentreFormationService implements CentreFormationServiceInterface {
    private final CentreFormationRepository centreFormationRepository;
    @Autowired
    public CentreFormationService(CentreFormationRepository centreFormationRepository) {
        this.centreFormationRepository = centreFormationRepository;
    }
}
