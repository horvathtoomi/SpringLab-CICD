package hu.bme.aut.Labor1;

public class CountryMapper {
    public CountryData mapCountryData(String line) {
        var arr = line.split(",");
        var name = arr[0].trim();
        var region = arr[1].trim();
        var population = Long.parseLong(arr[2].trim());
        var area = Long.parseLong(arr[3].trim());
        return new CountryData(name, region, population, area);
    }
}
