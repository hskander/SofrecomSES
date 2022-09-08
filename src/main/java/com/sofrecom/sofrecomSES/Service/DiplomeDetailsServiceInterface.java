package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Model.DiplomeDetails;

public interface DiplomeDetailsServiceInterface {
    void deleteDiplomeDetails(Long id);
    DiplomeDetails updateDiplomeDetails(DiplomeDetails diplomeDetails,Long employeId);
    DiplomeDetails addDiplomeDetails(DiplomeDetails diplomeDetails, Long idDiplome,Long idInstitut,Long employeId);
}
