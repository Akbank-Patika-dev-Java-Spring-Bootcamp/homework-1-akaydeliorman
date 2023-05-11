package com.akaydeliorman.bootcamp.countrymodel.mapper;

import com.akaydeliorman.bootcamp.countrymodel.Country;
import com.akaydeliorman.bootcamp.countrymodel.dto.request.CountryDtoRequest;
import com.akaydeliorman.bootcamp.countrymodel.dto.response.CountryDtoResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    Country countryDtoRequestToCountry (CountryDtoRequest dtoRequest);
    List<Country> countryDtoRequestsToCountries (List<CountryDtoRequest> dtoRequestList);
    Country countryDtoResponseToCountry (CountryDtoResponse dtoResponse);
    CountryDtoResponse countryToCountryDtoResponse (Country country);
    List<CountryDtoResponse> countriesToCountryDtoResponses (List<Country> countries);
}
