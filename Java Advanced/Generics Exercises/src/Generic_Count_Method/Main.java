package Generic_Count_Method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BoxList<Double> boxList = new BoxList<>();
        fillBoxList(boxList, reader);
        Double input = Double.parseDouble(reader.readLine());
        Box<Double> boxToCompareWith = new Box<>(input);
        Integer result = boxList.countOfBoxesGreaterThan(boxToCompareWith);
        System.out.println(result);
    }

    private static void fillBoxList(BoxList<Double> boxList, BufferedReader reader) throws IOException {
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            Double inputData = Double.parseDouble(reader.readLine());
            Box<Double> box = new Box<>(inputData);
            boxList.add(box);
        }
    }
}
