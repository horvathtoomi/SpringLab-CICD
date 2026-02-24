package hu.bme.aut.Labor1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountryMapperTest {

    @Test
    void mapCountryData() {
        var input = "Hungary, Europe, 1234, 123123, WESTERN EUROPE";
        CountryMapper mapper = new CountryMapper();
        CountryData countryData = mapper.mapCountryData(input);
        assertEquals("Hungary", countryData.country());
        assertEquals("Europe", countryData.region());
        assertEquals(1234, countryData.population());
        assertEquals(123123, countryData.area());
        assertEquals(Continent.EUROPE, countryData.continent());
    }
}