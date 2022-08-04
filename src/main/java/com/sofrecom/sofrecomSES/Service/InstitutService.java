package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Exeption.UserNotFoundException;
import com.sofrecom.sofrecomSES.Model.Institut;
import com.sofrecom.sofrecomSES.Repository.InstitutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstitutService implements InstitutServiceInterface {
    private final InstitutRepository institutRepository;
    @Autowired
    public InstitutService(InstitutRepository institutRepository) {
        this.institutRepository = institutRepository;
    }

    @Override
    public Institut addInstitut(Institut institut){

        return institutRepository.save(institut);
    }
    @Override
    public List<Institut> getAllInstituts(){

        return institutRepository.findAll();
    }

    @Override
    public  Institut updateInstitut(Institut institut){
        return institutRepository.save(institut);
    }

    @Override
    public Institut getInstitutById(Long id){
        return institutRepository.findInstitutById(id).
                orElseThrow(() -> new UserNotFoundException("Institut"+ id+"was not found"));
    }
    @Override
    public void deleteInstitut(Long id){
        institutRepository.deleteInstitutById(id);
    }

}

