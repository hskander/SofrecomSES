package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Model.DiplomeDetails;

public interface DiplomeDetailsServiceInterface {

    void deleteDiplomeDetails(Long id);
    DiplomeDetails updateDiplomeDetails(DiplomeDetails diplomeDetail);
    DiplomeDetails addDiplomeDetails(DiplomeDetails diplomeDetails, Long idDiplome,Long idInstitut);
}
