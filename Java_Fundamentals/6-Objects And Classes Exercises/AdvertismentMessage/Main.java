package AdvertismentMessage;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> phrases = Arrays.asList("Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can’t live without this product.");
        List<String> events = Arrays.asList("Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!");
        List<String> authors = Arrays.asList("Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva");
        List<String> cities = Arrays.asList("Burgas", "Sofia", "Plovdiv", "Varna", "Ruse");

        randomizeMessage(phrases, events, authors, cities, sc);
    }

    static void randomizeMessage(List<String> listOfPhrases, List<String> listOfEvents, List<String> listOfAuthors, List<String> listOfCities, Scanner sc){
        Random random = new Random();
        int numberOfMessages = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numberOfMessages; i++) {
            String phrase = listOfPhrases.get(random.nextInt(listOfPhrases.size()));
            String event = listOfEvents.get(random.nextInt(listOfEvents.size()));
            String author = listOfAuthors.get(random.nextInt(listOfAuthors.size()));
            String city = listOfCities.get(random.nextInt(listOfCities.size()));

            Message message = new Message(phrase, event, author, city);
            System.out.println(message.toString());//zabelejka moga da izvikam samo message bez da dostypvam toString metoda poneve e bashtin klas
        }
    }
}
