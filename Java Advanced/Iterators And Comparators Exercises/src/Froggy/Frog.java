package Froggy;

import java.util.Iterator;
import java.util.List;

public class Frog implements Iterator<String> {

    private String[] stones;
    private int index;

    public Frog(String[] stones) {
        this.stones = stones;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return this.index < this.stones.length;
    }

    @Override
    public String next() {
        String stone = this.stones[index];

        if (this.stones.length % 2 == 0 && this.index == this.stones.length - 2) {
            this.index = -1;
        } else if (this.stones.length % 2 != 0 && this.index == this.stones.length - 1) {
            this.index = -1;
        }

        this.index += 2;
        return stone;
    }
}
