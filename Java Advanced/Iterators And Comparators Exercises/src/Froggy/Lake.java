package Froggy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<String> {

    private String[] stones;


    public Lake(String... stones) {
        setStones(stones);
    }

    public void setStones(String... stones) {
        this.stones = stones;

//        List<String> evenStones = new ArrayList<>();
//        List<String> oddStones = new ArrayList<>();
//
//        for (int i = 0; i < stones.length; i++) {
//            String currentStone = stones[i];
//
//            if (i % 2 == 0) {
//                evenStones.add(currentStone);
//            } else {
//                oddStones.add(currentStone);
//            }
//        }
//
//        this.stones.addAll(evenStones);
//        this.stones.addAll(oddStones);
    }

    @Override
    public Iterator<String> iterator() {
        return new Frog(this.stones);
    }
}
