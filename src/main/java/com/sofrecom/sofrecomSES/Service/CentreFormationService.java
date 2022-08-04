package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Exeption.UserNotFoundException;
import com.sofrecom.sofrecomSES.Model.CentreFormation;
import com.sofrecom.sofrecomSES.Repository.CentreFormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CentreFormationService implements CentreFormationServiceInterface {
    private final CentreFormationRepository centreFormationRepository;

    @Autowired
    public CentreFormationService(CentreFormationRepository centreFormationRepository) {
        this.centreFormationRepository = centreFormationRepository;
    }
    @Override
    public CentreFormation addCentreFormation(CentreFormation centreFormation) {
        return centreFormationRepository.save(centreFormation);
    }

    @Override
    public List<CentreFormation> getAllCentresFormation() {
        return centreFormationRepository.findAll();
    }

    @Override
    public CentreFormation updateCentreFormation(CentreFormation centreFormation) {
        return centreFormationRepository.save(centreFormation);
    }

    @Override
    public CentreFormation getCentreFormationById(Long id){
        return centreFormationRepository.findCentreFormationById(id).
                orElseThrow(() -> new UserNotFoundException("Centre de formation"+ id+"was not found"));
    }
    @Override
    public void deleteCentreFormation(Long id){
        centreFormationRepository.deleteCentreFormationById(id);
    }
}
