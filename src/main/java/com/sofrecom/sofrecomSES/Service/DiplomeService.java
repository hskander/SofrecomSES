package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Exeption.UserNotFoundException;
import com.sofrecom.sofrecomSES.Model.Diplome;
import com.sofrecom.sofrecomSES.Repository.DiplomeRepository;
import com.sofrecom.sofrecomSES.Repository.InstitutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiplomeService implements DiplomeServiceInterface {
    private final DiplomeRepository diplomeRepository;
    private final InstitutRepository institutRepository;
    @Autowired
    public DiplomeService(DiplomeRepository diplomeRepository,InstitutRepository institutRepository) {
        this.diplomeRepository = diplomeRepository;
        this.institutRepository = institutRepository;
    }

    @Override
    public Diplome addDiplome(Diplome diplome){
        return this.diplomeRepository.save(diplome);
    }

    @Override
    public List<Diplome> getAllDiplomes(){
        return diplomeRepository.findAll();
    }

    @Override
    public  Diplome updateDiplome(Diplome diplome){
        return diplomeRepository.save(diplome);
    }

    @Override
    public Diplome getDiplomeById(Long id){
        return diplomeRepository.findDiplomeById(id).
                orElseThrow(() -> new UserNotFoundException("Diplome"+ id+"was not found"));
    }

    @Override
    public void deleteDiplome(Long id){
        diplomeRepository.deleteDiplomeById(id);
    }
}





