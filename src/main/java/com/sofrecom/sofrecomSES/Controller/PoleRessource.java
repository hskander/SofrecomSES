package com.sofrecom.sofrecomSES.Controller;

import com.sofrecom.sofrecomSES.Service.PoleServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Pole")
public class PoleRessource {
    private final PoleServiceInterface poleService;
    @Autowired
    public PoleRessource(PoleServiceInterface poleService) {

        this.poleService = poleService;
    }
}
