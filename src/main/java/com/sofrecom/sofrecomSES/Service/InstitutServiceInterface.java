package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Model.Institut;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface InstitutServiceInterface {

    Institut addInstitut(Institut institut);
    Institut getInstitutById(Long id);
    List<Institut> getAllInstituts() ;
    Institut updateInstitut( Institut institut) ;
    void deleteInstitut(Long id);
}
