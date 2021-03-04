package com.carsandusers.services.impl;

import com.carsandusers.entities.Owner;
import com.carsandusers.repositories.OwnerRepository;
import com.carsandusers.services.OwnerService;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner createOwner(Owner owner) {
        Owner test = ownerRepository.findByEmail(owner.getEmail());

        if (test == null){
            return ownerRepository.save(owner);
        }


        return test;

    }

    @Override
    public Owner save(Owner owner) {
        return this.ownerRepository.save(owner);
    }

    @Override
    public Owner getOwner(String email) {
        return ownerRepository.findByEmail(email);
    }
}
