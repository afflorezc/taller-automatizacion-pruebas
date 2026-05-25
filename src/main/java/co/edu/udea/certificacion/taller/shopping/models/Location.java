package co.edu.udea.certificacion.taller.shopping.models;

import co.edu.udea.certificacion.taller.shopping.utils.RandomValues;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import co.edu.udea.certificacion.taller.shopping.models.enums.Country;

public class Location {

    private static final Map<Country, Map<String, List<String>>> LOCATION_DATA =
        Map.of(

            Country.UNITED_STATES,
            Map.of(
                "California",
                List.of("Los Angeles", "San Diego", "San Francisco"),

                "Texas",
                List.of("Houston", "Dallas", "Austin")
            ),

            Country.CANADA,
            Map.of(
                "Ontario",
                List.of( "Toronto", "Ottawa"),

                "Quebec",
                List.of("Montreal", "Quebec City")
            ),

            Country.AUSTRALIA,
            Map.of( 
                "New South Wales",
                List.of("Sydney", "Newcastle", "Wollongong"),

                "Victoria",
                List.of("Melbourne", "Geelong", "Ballarat")
            ),

            Country.INDIA,
            Map.of(
                "Maharashtra",
                List.of("Mumbai", "Pune", "Nagpur"),

                "Karnataka",
                List.of("Bangalore", "Mysore", "Mangalore")
            ),

            Country.ISRAEL,
            Map.of( 
                "Tel Aviv District",
                List.of("Tel Aviv", "Holon", "Bat Yam"),

                "Jerusalem District",
                List.of("Jerusalem", "Beit Shemesh")
            ),

            Country.NEW_ZEALAND,
            Map.of(
                "Auckland",
                List.of("Auckland", "Manukau", "North Shore"),

                "Wellington",
                List.of("Wellington","Lower Hutt","Porirua")
            ),

            Country.SINGAPORE,
            Map.of(
                "Singapore",
                List.of("Jurong East", "Yishun")

            )
        );

    public static LocationData randomLocation() {

        Country country = randomCountry();

        Map<String, List<String>> states =
                LOCATION_DATA.get(country);

        List<String> stateNames =
                new ArrayList<>(states.keySet());

        String state = RandomValues.randomItem(stateNames);

        String city = RandomValues.randomItem(states.get(state));

        return new LocationData(
                country.getValue(),
                state,
                city
        );
    }

    private static Country randomCountry() {

        Country[] countries = Country.values();

        return countries[
            new Random().nextInt(countries.length)
        ];
    }

}
