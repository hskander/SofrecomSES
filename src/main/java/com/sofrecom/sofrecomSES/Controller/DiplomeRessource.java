package com.sofrecom.sofrecomSES.Controller;

import com.sofrecom.sofrecomSES.Service.DiplomeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Diplome")
public class DiplomeRessource {
    private final DiplomeServiceInterface diplomeService;
    @Autowired
    public DiplomeRessource(DiplomeServiceInterface diplomeService) {
        this.diplomeService = diplomeService;
    }
}
