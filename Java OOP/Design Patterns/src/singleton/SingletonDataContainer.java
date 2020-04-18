package singleton;

import java.util.HashMap;
import java.util.Map;

public class SingletonDataContainer implements SingletonContainer {
    private static SingletonDataContainer instance = null;
    private Map<String, Integer> capitalsPopulation;

    private SingletonDataContainer() {
        this.capitalsPopulation = new HashMap<>();
        System.out.println("SingletonDataContainer Is Initialized!");
    }

    public static synchronized SingletonDataContainer getInstance(){
        if (instance == null){
            instance = new SingletonDataContainer();
        }

        return instance;
    }

    @Override
    public int getPopulation(Map<String, Integer> capitalsPopulation, String name) {
        return capitalsPopulation.get(name);
    }
}
