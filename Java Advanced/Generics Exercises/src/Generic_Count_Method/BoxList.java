package Generic_Count_Method;

import java.util.ArrayList;
import java.util.List;

public class BoxList <T extends Comparable<T>> {

    private List<Box<T>> boxList;

    public BoxList(){
        this.boxList = new ArrayList<>();
    }

    public void add(Box<T> box){
        this.boxList.add(box);
    }


    public int countOfBoxesGreaterThan(Box<T> boxToCompareWith) {
        int count = 0;
        for (Box<T> box : boxList) {
            if (box.getData().compareTo(boxToCompareWith.getData()) > 0){
                count++;
            }
        }

        return count;
    }
}
