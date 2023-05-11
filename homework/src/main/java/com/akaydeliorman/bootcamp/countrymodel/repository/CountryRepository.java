package com.akaydeliorman.bootcamp.countrymodel.repository;

import com.akaydeliorman.bootcamp.countrymodel.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Long> {

}
