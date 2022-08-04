package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Model.Institut;

import java.util.List;

public interface InstitutServiceInterface {
    Institut addInstitut(Institut institut);
    Institut getInstitutById(Long id);
    List<Institut> getAllInstituts() ;
    Institut updateInstitut( Institut institut) ;
    void deleteInstitut(Long id);
}
