package Shapes;

public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(6.15, 18.2);
        Shape circle = new Circle(3.8);

        rectangle.calculatePerimeter();
        System.out.println(String.format("Rectangle perimeter is: %.2f", rectangle.getPerimeter()));

        rectangle.calculateArea();
        System.out.println(String.format("Rectangle area is: %.2f", rectangle.getArea()));

        circle.calculatePerimeter();
        System.out.println(String.format("Circle perimeter is: %.2f", circle.getPerimeter()));

        circle.calculateArea();
        System.out.println(String.format("Circle area is: %.2f", circle.getArea()));
    }
}
