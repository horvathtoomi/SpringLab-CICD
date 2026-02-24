package hu.bme.aut.Labor1;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    public static final String DATA_URL = "https://raw.githubusercontent.com/bnokoro/Data-Science/refs/heads/master/countries%20of%20the%20world.csv";

    .
    static void main() throws Exception{
        String csvData;
        try(var client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder().uri(new URI(DATA_URL)).build();
            csvData = client.send(request, HttpResponse.BodyHandlers.ofString()).body();

            var countryList = csvData.lines()
                    .skip(1)
                    .filter(line -> !line.startsWith("\""))
                    .map(line -> new CountryMapper().mapCountryData(line)).toList();
            System.out.printf(countryList.toString());
        }
    }

}
