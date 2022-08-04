package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Exeption.UserNotFoundException;
import com.sofrecom.sofrecomSES.Model.Direction;
import com.sofrecom.sofrecomSES.Model.Employe;
import com.sofrecom.sofrecomSES.Repository.DirectionRepository;
import com.sofrecom.sofrecomSES.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectionService implements DirectionServiceInterface {

    private final DirectionRepository directionRepository;
    private final EmployeeRepository employeeRepository;



    @Autowired
    public DirectionService(DirectionRepository directionRepository,EmployeeRepository employeeRepository)
    {
        this.directionRepository = directionRepository;
        this.employeeRepository = employeeRepository;
    }
    @Override
    public Direction addDirection(Direction direction,Long employeId) {

        Employe employe = this.employeeRepository.findEmployeById(employeId).
                orElseThrow(() -> new UserNotFoundException("User with ID " + employeId + " was not found"));

        direction.setManager(employe);
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
        directionRepository.deleteDirectionById(id);
    }









}
