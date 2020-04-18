package RawData;

import java.util.LinkedHashMap;
import java.util.Map;

public class Tires {

    private Map<Double, Integer> tirePressureAge;

    public Tires(){
        tirePressureAge = new LinkedHashMap<>();
    }

    public void setTirePressureAge(double pressure, int age){
        tirePressureAge.put(pressure, age);
    }

    public Map<Double, Integer> getTirePressureAge() {
        return this.tirePressureAge;
    }
}
