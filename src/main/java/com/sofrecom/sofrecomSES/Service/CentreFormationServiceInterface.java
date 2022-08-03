package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Model.CentreFormation;


import java.util.List;
public interface CentreFormationServiceInterface {
    List<CentreFormation> getAllCentresFormation();
    CentreFormation getCentreFormationById(Long id);
     void deleteCentreFormation(Long id);
    CentreFormation addCentreFormation(CentreFormation centreFormation);
    CentreFormation updateCentreFormation( CentreFormation centreFormation);
}
