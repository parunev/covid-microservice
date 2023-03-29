package com.example.jsontodb.controllers;

import com.example.jsontodb.domain.Country;
import com.example.jsontodb.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CountryController {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @GetMapping("/country/{countryCode}")
    @ResponseBody
    private Country getCountry(@PathVariable String countryCode){
        if (!countryCode.matches("^[A-Z]+$")) {
            throw new IllegalArgumentException("Country code is not in Uppercase");
        }
        return countryRepository.findByCountryCode(countryCode);
    }
}
