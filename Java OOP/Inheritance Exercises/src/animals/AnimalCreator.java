package animals;

public class AnimalCreator {

    public static Animal creatAnimalFromGivenType(String animalType, String[] animalData) {
        String name = animalData[0];
        int age = Integer.parseInt(animalData[1]);
        String gender = "";

        Animal animal = null;
        switch (animalType) {
            case "Dog":
                gender = animalData[2];
                animal = new Dog(name, age, gender);
                break;

            case "Cat":
                gender = animalData[2];
                animal = new Cat(name, age, gender);
                break;

            case "Frog":
                gender = animalData[2];
                animal = new Frog(name, age, gender);
                break;

            case "Kitten":
                animal = new Kitten(name, age);
                break;

            case "Tomcat":
                animal = new Tomcat(name, age);
                break;
        }
        return animal;
    }
}
