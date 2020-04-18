package Google;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String personName;
    private Company company;
    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Child> children;
    private Car car;

    public Person(String personName) {
        this.personName = personName;
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void addPokemon(Pokemon pokemon){
        this.pokemons.add(pokemon);
    }

    public void  addParent(Parent parent){
        this.parents.add(parent);
    }

    public Company getCompany() {
        return company;
    }

    public Car getCar() {
        return car;
    }

    public void addChild(Child child){
        this.children.add(child);
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


    public <T> void printData(String info, List<T> items){
        System.out.println(info + ":");
        if (pokemons.isEmpty()){
            return;
        }
        for (T item : items) {
            System.out.println(item);
        }
    }

    public <T> void printData(String info, T item){
        System.out.println(info + ":");

        if (item == null){
            return;
        }
        System.out.println(item);
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return String.format("%s", this.personName);
    }
}
