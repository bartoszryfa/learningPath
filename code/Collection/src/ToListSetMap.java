import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


import static java.util.stream.Collectors.*;


public class ToListSetMap {

    public static void run() {
        List<String> teams = new ArrayList<>();
        teams.add("Poland");
        teams.add("Slovakia");
        teams.add("Swiden");
        teams.add("Spain");
        teams.add("Spain");

        List<String> teamsStartingWithS = teams.stream()
                .filter(team -> team.startsWith("S"))
                .collect(toList());

        System.out.println(teamsStartingWithS);

        Set<String> setStartingWithS = teams.stream()
                .filter(team -> team.startsWith("S"))
                .collect(toSet());
        System.out.println(setStartingWithS);

        Country country = new Country("Poland", "Warsaw");
        Country country1 = new Country("Spain", "Madrid");
        Country country2 = new Country("Slovakia", "Bratislava");
        Country country3 = new Country("Swiden", "Stocholm");

        List<Country> countries = new ArrayList<>();
        countries.add(country);
        countries.add(country1);
        countries.add(country2);
        countries.add(country3);

        Map<String, String> countriesMap = countries.stream()
                .filter(countryFromMap -> countryFromMap.getName().startsWith("S"))
                .collect(toMap(Country::getName, Country::getCapital, (oldValue, newValue) -> newValue));
        System.out.println(countriesMap);
    }



}
