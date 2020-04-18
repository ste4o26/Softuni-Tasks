package Shapes;

public class Circle extends Shape {
    private static final double PI = Math.PI;

    private double radius;

    public Circle(double radius) {
        this.setRadius(radius);
    }

    public final double getRadius() {
        return this.radius;
    }

    private void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void calculatePerimeter() {
        double perimeter = 2 * PI * this.radius;
        super.setPerimeter(perimeter);
    }

    @Override
    public void calculateArea() {
        double radiusPowerOfTwo = Math.pow(this.radius, 2);
        double area = PI * radiusPowerOfTwo;
        super.setArea(area);
    }
}
