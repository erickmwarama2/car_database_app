package com.erick.cardatabase.repositories;

import java.util.List;
import java.util.Optional;

import com.erick.cardatabase.domain.Car;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CarRepository extends CrudRepository<Car, Long> {
    List<Car> findByBrand(@Param("brand") String brand);

    Optional<Car> findByRegisterNumber(@Param("number") String number);
}
