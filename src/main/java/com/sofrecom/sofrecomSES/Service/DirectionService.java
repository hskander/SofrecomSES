package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Exeption.UserNotFoundException;
import com.sofrecom.sofrecomSES.Model.Employe;
import com.sofrecom.sofrecomSES.Model.Pole;
import com.sofrecom.sofrecomSES.Repository.DirectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

@Service
public class DirectionService implements DirectionServiceInterface {
    private final DirectionRepository directionRepository;
    @Autowired
    public DirectionService(DirectionRepository directionRepository) {
        this.directionRepository = directionRepository;
    }

    @Override
    public Employe findDirectionManager(Long directionId) {
        return this.directionRepository.findDirectionById(directionId).
                orElseThrow(()->new UserNotFoundException("Direction with ID "+directionId+" was not found" ))
                .getManager();
    }
    @Override
    public List<Employe> findEmployeesDirection(Long directionId) {
        List<Pole> allPoles= this.directionRepository.findDirectionById(directionId).
                orElseThrow(()->new UserNotFoundException("Direction with ID "+directionId+" was not found" )).
                getPoles();
        List<Employe> allEmployeesDirection =new ArrayList<Employe>();
        for(Pole p:allPoles){
            allEmployeesDirection.addAll(p.getEmployes());
        }
        return allEmployeesDirection;
    }

}
