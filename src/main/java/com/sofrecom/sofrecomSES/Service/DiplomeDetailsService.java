package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Repository.DiplomeDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiplomeDetailsService implements DiplomeDetailsServiceInterface {
    private final DiplomeDetailsRepository diplomeDetailsRepository;
    @Autowired
    public DiplomeDetailsService(DiplomeDetailsRepository diplomeDetailsRepository) {
        this.diplomeDetailsRepository = diplomeDetailsRepository;
    }
}
