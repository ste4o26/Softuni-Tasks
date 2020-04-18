package rpg_lab;

import rpg_lab.interfaces.Target;
import rpg_lab.interfaces.Weapon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Dummy implements Target {

    private int health;
    private int experience;
    private List<Weapon> possibleLoot;

    public Dummy(int health, int experience) {
        this.health = health;
        this.experience = experience;
        this.possibleLoot = new ArrayList<>(Arrays.asList(new Axe(10, 10),
                new Axe(10, 10),
                new Axe(5, 5),
                new Axe(2, 2),
                new Axe(50, 50)));
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public void takeAttack(int attackPoints) {
        if (this.isDead()) {
            throw new IllegalStateException("Dummy is dead.");
        }

        this.health -= attackPoints;
    }

    @Override
    public int giveExperience() {
        if (!this.isDead()) {
            throw new IllegalStateException("Target is not dead.");
        }

        return this.experience;
    }

    @Override
    public boolean isDead() {
        return this.health <= 0;
    }

    @Override
    public Weapon givesLootUponDeath() {
        Random random = new Random();
        if (this.isDead()) {
            return possibleLoot.get(random.nextInt(this.possibleLoot.size()));
        }

        throw new IllegalStateException("Can not get loot from alive target!");
    }
}
