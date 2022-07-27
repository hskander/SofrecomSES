package com.sofrecom.sofrecomSES.Controller;

import com.sofrecom.sofrecomSES.Service.PosteServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Poste")
public class PosteRessource {
    private final PosteServiceInterface posteService;
    @Autowired
    public PosteRessource(PosteServiceInterface posteService) {

        this.posteService = posteService;
    }
}
