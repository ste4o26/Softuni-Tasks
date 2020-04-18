package Shapes;

public class Rectangle extends Shape {
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.setHeight(height);
        this.setWidth(width);
    }

    public double getHeight() {
        return this.height;
    }

    private void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return this.width;
    }

    private void setWidth(double width) {
        this.width = width;
    }

    @Override
    public void calculatePerimeter() {
        double perimeter = 2 * (this.height + this.width);
        super.setPerimeter(perimeter);
    }

    @Override
    public void calculateArea() {
        double area = this.height * this.width;
        super.setArea(area);
    }
}
