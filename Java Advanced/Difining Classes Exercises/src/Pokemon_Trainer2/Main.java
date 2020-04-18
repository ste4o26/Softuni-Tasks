package Pokemon_Trainer2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Trainer> trainers = new LinkedHashMap<>();

        String inputLine = reader.readLine();
        while (!"Tournament".equals(inputLine)) {
            String[] tokens = inputLine.split("\\s+");

            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            String trainerName = tokens[0];
            Trainer trainer = trainers.get(trainerName);

            if (!trainers.containsKey(trainerName)) {
                trainer = new Trainer(trainerName);
                trainer.addPokemon(pokemonName, pokemon);
                trainers.put(trainerName, trainer);
            } else {
                trainer.addPokemon(pokemonName, pokemon);
                trainers.put(trainerName, trainer);
            }

            inputLine = reader.readLine();
        }


        inputLine = reader.readLine();
        while (!"End".equals(inputLine)) {
            String element = inputLine;

            for (Trainer trainer : trainers.values()) {
                if (trainer.hasPokemonOfGivenElement(element)) {
                    trainer.incrementBadges();
                } else {
                    trainer
                            .getPokemons()
                            .values()
                            .forEach(Pokemon::decreaseHealth);
                }
            }

            inputLine = reader.readLine();
        }

        Predicate<Pokemon> isDeath = (pokemon -> !(pokemon.getHealth() <= 0));
        Consumer<Trainer> removeDeathPokemons = (trainer -> {
            Map<String, Pokemon> pokemonsLeft = trainer
                    .getPokemons()
                    .values()
                    .stream()
                    .filter(isDeath::test)
                    .collect(Collectors.toMap(Pokemon::getName, pokemon -> pokemon));

            trainer.setPokemons(pokemonsLeft);
        });

        trainers
                .values()
                .forEach(removeDeathPokemons::accept);

        trainers
                .values()
                .stream()
                .sorted((trainer1, trainer2) -> Integer.compare(trainer2.getNumberOfBadges(), trainer1.getNumberOfBadges()))
                .forEach(System.out::println);
    }
}
