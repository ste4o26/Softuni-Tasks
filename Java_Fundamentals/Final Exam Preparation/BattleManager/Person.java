package BattleManager;

public class Person {

        private String name;
        private int health;
        private int energy;

        public Person(String name, int health, int energy) {
            this.name = name;
            this.health = health;
            this.energy = energy;
        }

        public String getName() {
            return name;
        }

        public int getHealth() {
            return health;
        }

        public int getEnergy() {
            return energy;
        }

        public void setHealth(int health) {
            this.health = health;
        }

        public void setEnergy(int energy) {
            this.energy = energy;
        }
    }
