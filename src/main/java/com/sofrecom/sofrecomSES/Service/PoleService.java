package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Exeption.UserNotFoundException;
import com.sofrecom.sofrecomSES.Model.Direction;
import com.sofrecom.sofrecomSES.Model.Employe;
import com.sofrecom.sofrecomSES.Model.Pole;
import com.sofrecom.sofrecomSES.Repository.DirectionRepository;
import com.sofrecom.sofrecomSES.Repository.EmployeeRepository;
import com.sofrecom.sofrecomSES.Model.Employe;
import com.sofrecom.sofrecomSES.Repository.PoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoleService implements PoleServiceInterface {
    private final PoleRepository poleRepository;

    private final EmployeeRepository employeeRepository;

    private final DirectionRepository directionRepository;

    @Autowired
    public PoleService(PoleRepository poleRepository,EmployeeRepository employeeRepository,DirectionRepository directionRepository) {
        this.poleRepository = poleRepository;
        this.employeeRepository = employeeRepository;
        this.directionRepository = directionRepository;
    }
    @Override
    public List<Pole> getAllPoles() {
        return poleRepository.findAll();
    }

    @Override
    public Pole getPoleById(Long id) {
        return poleRepository.findPoleById(id)
                .orElseThrow(() -> new UserNotFoundException("pole " + id + " was not found"));
    }
    @Override
    public void deletePole(Long id) {
        Pole pole =this.getPoleById(id);
        for(Employe e:pole.getEmployes()){
            e.setPole(null);
            this.employeeRepository.save(e);
        }
        poleRepository.deletePoleById(id);
    }

    @Override
    public Pole addPole(Pole pole, Long DirectionId) {
        Direction direction = this.directionRepository.findDirectionById(DirectionId).
                orElseThrow(() -> new UserNotFoundException("Direction with ID " + DirectionId + " was not found"));
        pole.setDirection(direction);
        return this.poleRepository.save(pole);
    }

    @Override
    public Pole affecterManagerPole(Long poleId, Long employeeId) {
        Employe employe = this.employeeRepository.findEmployeById(employeeId).
                orElseThrow(() -> new UserNotFoundException("employe with ID " + employeeId + " was not found"));
        Pole pole=this.poleRepository.findPoleById(poleId)
                .orElseThrow(() -> new UserNotFoundException("Pole with ID " + poleId + " was not found"));
        pole.setManager(employe);
        pole.setResponsablePole(employe.getNom()+' '+employe.getPrenom());
        return this.poleRepository.save(pole);
    }

    @Override
    public Pole editPole(Pole pole){
        return this.poleRepository.save(pole);
    }

}


