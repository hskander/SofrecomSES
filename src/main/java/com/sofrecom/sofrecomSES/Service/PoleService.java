package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Exeption.UserNotFoundException;
import com.sofrecom.sofrecomSES.Model.Employe;
import com.sofrecom.sofrecomSES.Model.Pole;
import com.sofrecom.sofrecomSES.Repository.PoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoleService implements PoleServiceInterface {
    private final PoleRepository poleRepository;
    @Autowired
    public PoleService(PoleRepository poleRepository) {
        this.poleRepository = poleRepository;
    }
    @Override
    public Employe findPoleManager(Long poleId){
        Pole pole =this.poleRepository.findPoleById(poleId).
                orElseThrow(()->new UserNotFoundException("pole with ID "+poleId+" was not found" ));
        return pole.getManager();
    }

    @Override
    public List<Employe> findEmployeesPole(Long poleId) {
        return this.poleRepository.findPoleById(poleId).
                orElseThrow(()->new UserNotFoundException("Pole with ID "+poleId+" was not found" )).getEmployes();
    }
}
