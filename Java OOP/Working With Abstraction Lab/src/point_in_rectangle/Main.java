package point_in_rectangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] tokens = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int bottomLeftX = tokens[0];
        int bottomLeftY = tokens[1];
        Point bottomLeftPoint = new Point(bottomLeftX, bottomLeftY);

        int topRightX = tokens[2];
        int topRightY = tokens[3];
        Point topRightPoint = new Point(topRightX, topRightY);

        Rectangle rectangle = new Rectangle(bottomLeftPoint, topRightPoint);
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            tokens = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int coordinateX = tokens[0];
            int coordinateY = tokens[1];
            Point point = new Point(coordinateX, coordinateY);

            System.out.println(rectangle.containsPoint(point));
        }
    }
}
