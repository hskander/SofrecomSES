package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Model.DiplomeDetails;

public interface DiplomeDetailsServiceInterface {
    DiplomeDetails addDiplomeDetails(DiplomeDetails diplomeDetails, Long idDiplome,Long idInstitut,Long employeId);
}
