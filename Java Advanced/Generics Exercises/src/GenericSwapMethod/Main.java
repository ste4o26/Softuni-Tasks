package GenericSwapMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BoxList<Integer> boxList = new BoxList<>();
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            int dataInput = Integer.parseInt(reader.readLine());
            Box<Integer> box = new Box<>(dataInput);
            boxList.addBox(box);
        }

        String[] tokens = reader.readLine().split("\\s+");
        int index = Integer.parseInt(tokens[0]);
        int indexToSwapWith = Integer.parseInt(tokens[1]);

        boxList.swap(index, indexToSwapWith);
        boxList.printEachElement();
    }
}
