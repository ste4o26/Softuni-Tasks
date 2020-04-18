package traffic_lights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TrafficLight[] trafficLights = Arrays.stream(reader.readLine().split("\\s+"))
                .map(TrafficLight::valueOf)
                .toArray(TrafficLight[]::new);

        int n = Integer.parseInt(reader.readLine());

        TrafficLight[] lights = TrafficLight.values();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < trafficLights.length; j++) {
                int index = (trafficLights[j].ordinal() + 1) % lights.length;
                trafficLights[j] = lights[index];

                TrafficLight currentLight = trafficLights[j];
                System.out.print(currentLight.toString() + " ");
            }
            System.out.println();
        }
    }
}
