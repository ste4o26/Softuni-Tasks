package zoo;

public class Main {
    public static void main(String[] args) {
        Reptile reptile = new Reptile("Kircho");
        Lizard lizard = new Lizard("Gushtera");

        Mammal mammal = new Mammal("Choki");
        Gorilla gorilla = new Gorilla("Maimunko");

        System.out.println(reptile.getName());
        System.out.println(lizard.getName());
        System.out.println(mammal.getName());
        System.out.println(gorilla.getName());
    }
}
