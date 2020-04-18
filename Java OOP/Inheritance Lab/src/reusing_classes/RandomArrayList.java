package reusing_classes;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {

    public T getRandomElement() {
        int randomIndex = getRandomIndex();
        return super.remove(randomIndex);
    }

    private int getRandomIndex() {
        Random random = new Random();
        return random.nextInt(super.size());
    }

}
