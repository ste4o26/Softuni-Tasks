package BattleManager;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String inputLine = sc.nextLine();
        Map<String, Person> personDetails = new TreeMap<>();
        while (!inputLine.equals("Results")) {
            String[] tokens = inputLine.split(":");
            String command = tokens[0];
            switch (command) {
                case "Add":
                    String personName = tokens[1];
                    int personHealth = Integer.parseInt(tokens[2]);
                    int personEnergy = Integer.parseInt(tokens[3]);
                    if (personDetails.containsKey(personName)) {
                        Person person = personDetails.get(personName);
                        int newHealth = person.getHealth() + personHealth;
                        person.setHealth(newHealth);
                        personDetails.put(personName, person);
                    } else {
                        Person person = new Person(personName, personHealth, personEnergy);
                        personDetails.put(personName, person);
                    }
                    break;
                case "Attack":
                    String attackerName = tokens[1];
                    String defenderName = tokens[2];
                    int damage = Integer.parseInt(tokens[3]);

                    if (personDetails.containsKey(attackerName) && personDetails.containsKey(defenderName)) {
                        int reducedHealth = personDetails.get(defenderName).getHealth() - damage;
                        if (reducedHealth <= 0) {
                            personDetails.remove(defenderName);
                            System.out.printf("%s was disqualified!%n", defenderName);
                        } else {
                            Person person = personDetails.get(defenderName);
                            person.setHealth(reducedHealth);
                            personDetails.put(defenderName, person);
                        }

                        int reducedEnergy = personDetails.get(attackerName).getEnergy() - 1;
                        if (reducedEnergy <= 0) {
                            personDetails.remove(attackerName);
                            System.out.printf("%s was disqualified!%n", attackerName);
                        } else {
                            Person person = personDetails.get(attackerName);
                            person.setEnergy(reducedEnergy);
                            personDetails.put(attackerName, person);
                        }
                    }
                    break;
                case "Delete":
                    String userName = tokens[1];
                    if (userName.equals("All")) {
                        personDetails.clear();
                    } else {
                        while (personDetails.containsKey(userName)) {
                            personDetails.remove(userName);
                        }
                    }
                    break;

            }

            inputLine = sc.nextLine();
        }

        System.out.printf("People count: %d%n", personDetails.size());
        personDetails.entrySet()
                .stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().getHealth(), e1.getValue().getHealth()))
                .forEach(entry -> {
                    System.out.printf("%s - %d - %d%n", entry.getValue().getName(), entry.getValue().getHealth(), entry.getValue().getEnergy());
                });
    }
}

