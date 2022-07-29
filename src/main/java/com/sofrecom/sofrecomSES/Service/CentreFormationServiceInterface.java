package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Model.CentreFormation;
import com.sofrecom.sofrecomSES.Model.Entreprise;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
public interface CentreFormationServiceInterface {
    List<CentreFormation> getAllCentresFormation();
    CentreFormation getCentreFormationById(Long id);
     void deleteCentreFormation(Long id);
    CentreFormation addCentreFormation(CentreFormation centreFormation);
    CentreFormation updateCentreFormation( CentreFormation centreFormation);
}
