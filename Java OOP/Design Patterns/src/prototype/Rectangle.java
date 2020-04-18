package prototype;

import java.util.ArrayList;
import java.util.List;

public class Rectangle implements Shape {
    private double sideA;
    private double sideB;
    private List<String> messages;

    public Rectangle(double sideA, double sideB, List<String> messages) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.messages = messages;
    }

    public List<String> getMessages() {
        return this.messages;
    }

    @Override
    public Shape clone() {
        return new  Rectangle(this.sideA, this.sideB, new ArrayList<>(this.messages));
    }

    @Override
    public double getArea() {
        return sideA * sideB;
    }

    @Override
    public String toString() {
        return "Rectangle: " +
                "sideA = " + sideA +
                ", sideB = " + sideB +
                ", messages = " + messages;
    }
}
