package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Exeption.UserNotFoundException;
import com.sofrecom.sofrecomSES.Model.Entreprise;
import com.sofrecom.sofrecomSES.Model.Institut;
import com.sofrecom.sofrecomSES.Repository.EntrepriseRepository;
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
    public Institut addInstitut(Institut institut){
        return institutRepository.save(institut);
    }
    public List<Institut> getAllInstituts(){

        return institutRepository.findAll();
    }
    public  Institut updateInstitut(Institut institut){

        return institutRepository.save(institut);
    }

    public Institut getInstitutById(Long id){
        return institutRepository.findInstitutById(id).
                orElseThrow(() -> new UserNotFoundException("User by id"+ id+"was not found"));
    }
    public void deleteInstitut(Long id){
        institutRepository.deleteInstitutById(id);
    }

}

