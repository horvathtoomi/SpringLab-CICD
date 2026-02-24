package hu.bme.aut.Labor1;

public class CountryMapper {
    public CountryData mapCountryData(String line) {
        var arr = line.split(",");
        var name = arr[0].trim();
        var region = arr[1].trim();
        var population = Long.parseLong(arr[2].trim());
        var area = Long.parseLong(arr[3].trim());

        String normalized = region.toUpperCase();

        Continent continent = switch (normalized) {
            case String s when s.contains("ASIA") -> Continent.ASIA;
            case String s when s.contains("NEAR EAST") -> Continent.ASIA;
            case String s when s.contains("C.W. OF IND. STATES") -> Continent.ASIA;
            case String s when s.contains("EUROPE") -> Continent.EUROPE;
            case String s when s.contains("BALTICS") -> Continent.EUROPE;
            case String s when s.contains("AFRICA") -> Continent.AFRICA;
            case String s when s.contains("OCEANIA") -> Continent.AUSTRALIA;
            case String s when s.contains("LATIN AMER") -> Continent.SOUTH_AMERICA;
            case String s when s.contains("NORTHERN AMERICA") -> Continent.NORTH_AMERICA;
            default -> throw new IllegalArgumentException("Unknown region: " + region);
        };
        return new CountryData(name, region, population, area, continent);
    }
}
