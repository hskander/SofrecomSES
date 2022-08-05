package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Exeption.UserNotFoundException;
import com.sofrecom.sofrecomSES.Model.Direction;
import com.sofrecom.sofrecomSES.Model.Employe;
import com.sofrecom.sofrecomSES.Model.Employe;
import com.sofrecom.sofrecomSES.Model.Pole;
import com.sofrecom.sofrecomSES.Repository.DirectionRepository;
import com.sofrecom.sofrecomSES.Repository.EmployeeRepository;
import com.sofrecom.sofrecomSES.Repository.PoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DirectionService implements DirectionServiceInterface {

    private final DirectionRepository directionRepository;
    private final EmployeeRepository employeeRepository;
    private final PoleRepository poleRepository;


    @Autowired
    public DirectionService(DirectionRepository directionRepository,EmployeeRepository employeeRepository
    ,PoleRepository poleRepository)
    {
        this.directionRepository = directionRepository;
        this.employeeRepository = employeeRepository;
        this.poleRepository=poleRepository;
    }
    @Override
    public Direction addDirection(Direction direction) {
        return this.directionRepository.save(direction);
    }

    @Override
    public Direction affecterManagerDirection(Long directionId, Long employeId) {
        Employe employe = this.employeeRepository.findEmployeById(employeId).
                orElseThrow(() -> new UserNotFoundException("User with ID " + employeId + " was not found"));
        Direction direction=this.directionRepository.findDirectionById(directionId).
                orElseThrow(()->new UserNotFoundException("Direction with ID "+directionId+" was not found" ));
        direction.setManager(employe);
        direction.setResponsableDirection(employe.getNom()+' '+employe.getPrenom());
        return this.directionRepository.save(direction);
    }

    @Override
    public List<Direction> getAllDirections() {
        return directionRepository.findAll();
    }
    @Override
    public Direction updateDirection(Direction direction) {
        return directionRepository.save(direction);
    }
    @Override
    public Direction getDirectionById(Long id) {
        return directionRepository.findDirectionById(id)
                .orElseThrow(() -> new UserNotFoundException("direction " + id + " was not found"));
    }
    @Override
    public void deleteDirection(Long id) {
        Direction direction= this.getDirectionById(id);
        for(Pole p:direction.getPoles()){
            p.setDirection(null);
            this.poleRepository.save(p);
        }
        directionRepository.deleteDirectionById(id);
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
