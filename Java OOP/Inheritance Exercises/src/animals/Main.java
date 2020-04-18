package animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final String BEAST = "Beast!";

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String animalType = reader.readLine();
        while (!BEAST.equals(animalType)) {

            String[] animalData = reader
                    .readLine()
                    .split("\\s+");

            Animal animal = null;
            try {
                animal = AnimalCreator.creatAnimalFromGivenType(animalType, animalData);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
                animalType = reader.readLine();
                continue;
            }

            System.out.println(animal.toString());
            System.out.println(animal.produceSound());


//            try {
//                if (animal == null) {
//                    throw new NullPointerException("Animal not created successfully");
//                }
//            } catch (NullPointerException npe) {
//                System.out.println(npe.getMessage());
//            }

            animalType = reader.readLine();
        }
    }
}
