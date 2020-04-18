package singleton;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> capitalsPopulation = new HashMap<>();
        capitalsPopulation.put("Sofia", 1200000);
        capitalsPopulation.put("Targovishte", 50000);

        SingletonDataContainer singletonDataContainer = SingletonDataContainer.getInstance();
        int sofiaPopulation = singletonDataContainer.getPopulation(capitalsPopulation, "Sofia");
        int targovishtePopulation = singletonDataContainer.getPopulation(capitalsPopulation, "Targovishte");

        System.out.println(sofiaPopulation);
        System.out.println(targovishtePopulation);
    }
}
