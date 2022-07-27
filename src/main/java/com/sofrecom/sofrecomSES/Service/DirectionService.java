package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Repository.DirectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectionService implements DirectionServiceInterface {
    private final DirectionRepository directionRepository;
    @Autowired
    public DirectionService(DirectionRepository directionRepository) {
        this.directionRepository = directionRepository;
    }
}
