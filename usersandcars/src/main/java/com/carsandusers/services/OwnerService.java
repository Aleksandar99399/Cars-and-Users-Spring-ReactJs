package com.carsandusers.services;

import com.carsandusers.entities.Owner;

public interface OwnerService {

    Owner createOwner(Owner owner);

    Owner save(Owner owner);

    Owner getOwner(String  email);

    boolean requiredOwner(Owner owner);
}
