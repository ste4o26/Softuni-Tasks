package aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {

    //DA SE VNIMAVA S SHIBANIQ OUTPUT ZA SPEIS ILI NOV RED
    //RABOTI S MAP !!!!!!!

    private List<Fish> fishInPool;
    private String name;
    private int capacity;
    private int size;//volume

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        fishInPool = new ArrayList<>();
    }

    public void add(Fish fish) {
        boolean isUnique = true;
        if (this.fishInPool.size() < this.getCapacity()) {
            for (Fish currentFish : this.fishInPool) {
                if (currentFish.getName().equals(fish.getName())) {
                    isUnique = false;
                    break;
                }
            }
        } else {
            isUnique = false;
        }

        if (isUnique) {
            this.fishInPool.add(fish);
        }

    }

    public boolean remove(String name) {
        for (Fish fish : this.fishInPool) {
            String currentFishName = fish.getName();
            if (name.equals(currentFishName)) {
                this.fishInPool.remove(fish);
                return true;
            }
        }
        return false;
    }

    public Fish findFish(String name) {
        for (Fish fish : this.fishInPool) {
            String currentFishName = fish.getName();
            if (currentFishName.equals(name)){
                return fish;
            }
        }
        return null;
    }

    //DA SE VNIMAVA S SHIBANIQ OUTPUT ZA SPEIS ILI NOV RED
    //RABOTI S MAP !!!!!!!
    public String report() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Aquarium: %s ^ Size: %d", this.getName(), this.getSize()));
        result.append(System.lineSeparator());
        for (Fish fish : this.fishInPool) {
            result.append(fish.toString());
            result.append(System.lineSeparator());
        }

        return result.toString();
    }

    public int getFishInPool() {
        return this.fishInPool.size();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getSize() {
        return this.size;
    }
}
