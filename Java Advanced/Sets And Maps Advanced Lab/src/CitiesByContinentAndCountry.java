import java.util.*;

public class CitiesByContinentAndCountry {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<String, Map<String, List<String>>> continents = new LinkedHashMap<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split("\\s+");
            String continentName = tokens[0];
            String countryName = tokens[1];
            String townName = tokens[2];
            Map<String, List<String>> countries = continents.get(continentName);

            if (continents.containsKey(continentName)) {
                List<String> towns = countries.get(countryName);

                if (countries.containsKey(countryName)){
                    towns.add(townName);
                    countries.put(countryName, towns);
                    continents.put(continentName, countries);
                }else {
                    towns = new ArrayList<>();
                    towns.add(townName);
                    countries.put(countryName, towns);
                    continents.put(continentName, countries);
                }

            } else {
                List<String> towns = new ArrayList<>();
                towns.add(townName);

                countries = new LinkedHashMap<>();
                countries.put(countryName, towns);

                continents.put(continentName, countries);
            }
        }

        continents
                .entrySet()
                .stream()
                .forEach(e -> {
                    String continent = e.getKey();
                    System.out.println(continent + ":");
                    Map<String, List<String>> countries = e.getValue();
                    countries
                            .entrySet()
                            .forEach(e2 -> {
                                String country = e2.getKey();
                                System.out.print(country + " -> ");
                                List<String> towns = e2.getValue();
                                System.out.println(String.join(", ", towns));
                            });
                });
    }
}
