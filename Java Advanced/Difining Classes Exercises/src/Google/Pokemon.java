package Google;

public class Pokemon {

    private String pokemonName;
    private String element;


    public Pokemon(String pokemonName, String element) {
        this.pokemonName = pokemonName;
        this.element = element;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.pokemonName, this.element);
    }
}
