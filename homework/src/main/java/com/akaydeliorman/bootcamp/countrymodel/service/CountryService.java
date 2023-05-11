package com.akaydeliorman.bootcamp.countrymodel.service;

import com.akaydeliorman.bootcamp.countrymodel.Country;
import com.akaydeliorman.bootcamp.countrymodel.dto.request.CountryDtoRequest;
import com.akaydeliorman.bootcamp.countrymodel.dto.response.CountryDtoResponse;
import com.akaydeliorman.bootcamp.countrymodel.mapper.CountryMapper;
import com.akaydeliorman.bootcamp.countrymodel.repository.CountryRepository;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    private CountryRepository countryRepository;
    private CountryMapper countryMapper;

    public CountryService(CountryRepository countryRepository, CountryMapper countryMapper) {
        this.countryRepository = countryRepository;
        this.countryMapper = countryMapper;
    }

    public CountryDtoResponse getCountryById(Long id){
        Country country = countryRepository.findById(id).orElseThrow();
        return countryMapper.countryToCountryDtoResponse(country);
    }

    public List<CountryDtoResponse> getAllCountries(){
        List<Country> countriesInDB = countryRepository.findAll();
        return countryMapper.countriesToCountryDtoResponses(countriesInDB);
    }

    public Country saveCountry(CountryDtoRequest countryDtoRequest){
        Country country = countryMapper.countryDtoRequestToCountry(countryDtoRequest);
        return countryRepository.save(country);
    }

    public void deleteCountry(Long id){
        CountryDtoResponse countryDto = getCountryById(id);
        Country countryInDB = countryMapper.countryDtoResponseToCountry(countryDto);
        countryRepository.delete(countryInDB);
    }

    public CountryDtoResponse updatePresident(Long id,String president){
        CountryDtoResponse dtoResponse = this.getCountryById(id);
        dtoResponse.setPresident(president);
        Country country = countryMapper.countryDtoResponseToCountry(dtoResponse);
        countryRepository.save(country);
        return dtoResponse;
    }

}
