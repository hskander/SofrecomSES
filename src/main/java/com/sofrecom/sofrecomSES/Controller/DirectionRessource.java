package com.sofrecom.sofrecomSES.Controller;

import com.sofrecom.sofrecomSES.Service.DirectionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Direction")
public class DirectionRessource {
    private final DirectionServiceInterface directionService;
    @Autowired
    public DirectionRessource(DirectionServiceInterface directionService) {

        this.directionService = directionService;
    }
}
