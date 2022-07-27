package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Repository.InstitutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstitutService implements InstitutServiceInterface {
    private final InstitutRepository institutRepository;
    @Autowired
    public InstitutService(InstitutRepository institutRepository) {
        this.institutRepository = institutRepository;
    }
}
