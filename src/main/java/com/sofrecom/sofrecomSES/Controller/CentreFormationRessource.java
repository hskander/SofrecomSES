package com.sofrecom.sofrecomSES.Controller;

import com.sofrecom.sofrecomSES.Service.CentreFormationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/CentreFormation")
public class CentreFormationRessource {
    private final CentreFormationServiceInterface centreFormationService;
    @Autowired
    public CentreFormationRessource(CentreFormationServiceInterface centreFormationService) {
        this.centreFormationService = centreFormationService;
    }
}
