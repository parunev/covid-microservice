package com.example.jsontodb.repositories;

import com.example.jsontodb.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    Country findByCountryCode(String countryCode);
}
