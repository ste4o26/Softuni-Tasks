package prototype;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(10, 10, new ArrayList<String>(List.of("I am rectangle")));

        Rectangle cloneRectangle = (Rectangle) rectangle.clone();
        cloneRectangle.getMessages().add("I am cloned rectangle");

        System.out.println("Real " + rectangle);
        System.out.println("Area: " + rectangle.getArea());

        System.out.println("Clone " + cloneRectangle);
        System.out.println("Area: " + cloneRectangle.getArea());

    }
}
