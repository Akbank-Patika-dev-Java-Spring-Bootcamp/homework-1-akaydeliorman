package com.akaydeliorman.bootcamp.countrymodel.controller;

import com.akaydeliorman.bootcamp.countrymodel.dto.request.CountryDtoRequest;
import com.akaydeliorman.bootcamp.countrymodel.dto.response.CountryDtoResponse;
import com.akaydeliorman.bootcamp.countrymodel.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1.0/countries")
public class CountryController {
    @Autowired
    private CountryService countryService;
    @GetMapping("/{id}")
    public ResponseEntity getCountryById(@PathVariable Long id){
        CountryDtoResponse countryDtoResponse = countryService.getCountryById(id);
        return ResponseEntity.ok(countryDtoResponse);
    }
    @GetMapping
    public ResponseEntity getAllCountries(){
        List<CountryDtoResponse> countryDtoResponseList = countryService.getAllCountries();
        return ResponseEntity.ok(countryDtoResponseList);
    }
    @PostMapping
    public ResponseEntity saveCountry(@RequestBody CountryDtoRequest countryDtoRequest){
        return ResponseEntity.ok(countryService.saveCountry(countryDtoRequest));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCountry(@PathVariable Long id){
        countryService.deleteCountry(id);
        return ResponseEntity.ok("deleted");
    }
    @PutMapping("/{id}")
    public ResponseEntity updateCountryPresident(@PathVariable Long id,@RequestBody String president){
        return ResponseEntity.ok(countryService.updatePresident(id,president));
    }
}
