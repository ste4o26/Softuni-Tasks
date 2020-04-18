package GenericSwapMethod;

import java.util.ArrayList;
import java.util.List;

public class BoxList <T>{

    private List<Box> boxList;

    public BoxList() {
        this.boxList = new ArrayList<>();
    }

    public void addBox(Box<T> box){
        this.boxList.add(box);
    }

    public void swap(int index, int indexToSwapWith){
        Box temp = this.boxList.get(index);

        Box boxToSwapWith = this.boxList.get(indexToSwapWith);
        this.boxList.set(index, boxToSwapWith);

        this.boxList.set(indexToSwapWith, temp);

    }

    public void printEachElement() {
        for (Box box: this.boxList) {
            System.out.println(box.toString().split("class ")[1]);
        }
    }
}
