package Pokemon_Trainer2;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public class Trainer {
    //name, number of badges and a collection of pokemon.
    private String name;
    private int numberOfBadges;
    private Map<String, Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.numberOfBadges = 0;
        this.pokemons = new LinkedHashMap<>();
    }

    public Map<String, Pokemon> getPokemons() {
        return this.pokemons;
    }

    public void setPokemons(Map<String, Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public boolean hasPokemonOfGivenElement(String element) {
        Predicate<Pokemon> areEqualsElements = (pokemon -> element.equals(pokemon.getElement()));
        return this
                .getPokemons()
                .values()
                .stream()
                .anyMatch(areEqualsElements::test);
    }

    public void addPokemon(String pokemonName, Pokemon pokemon){
        this.pokemons.putIfAbsent(pokemonName, pokemon);
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public void incrementBadges() {
        this.numberOfBadges++;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d", this.name, this.getNumberOfBadges(), this.getPokemons().size());
    }


}
