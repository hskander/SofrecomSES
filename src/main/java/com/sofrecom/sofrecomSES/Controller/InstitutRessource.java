package com.sofrecom.sofrecomSES.Controller;

import com.sofrecom.sofrecomSES.Service.InstitutServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Institut")
public class InstitutRessource {
    private final InstitutServiceInterface institutService;
    @Autowired
    public InstitutRessource(InstitutServiceInterface institutService) {
        this.institutService = institutService;
    }
}
