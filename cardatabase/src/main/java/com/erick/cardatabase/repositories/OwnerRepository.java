package com.erick.cardatabase.repositories;

import com.erick.cardatabase.domain.Owner;

import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    
}
