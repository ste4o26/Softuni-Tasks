package box;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    private double getLength() {
        return this.length;
    }

    private void setLength(double length) {
        if (isValueLessThenOne(length)) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        } else {
            this.length = length;
        }
    }

    private double getWidth() {
        return this.width;
    }

    private void setWidth(double width) {
        if (isValueLessThenOne(width)){
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }else {
            this.width = width;
        }
    }

    private double getHeight() {
        return this.height;
    }

    private void setHeight(double height) {
        if (isValueLessThenOne(height)){
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }else {
            this.height = height;
        }
    }

    private boolean isValueLessThenOne(double value) {
        return value < 1;
    }

    public double calculateSurfaceArea() {
        //2lw + 2lh + 2wh
        return (2 * getLength() * getWidth()) + (2 * getLength() * getHeight()) + (2 * getWidth() * getHeight());
    }

    public double calculateLateralSurfaceArea() {
        //2lh + 2wh
        return (2 * getLength() * getHeight()) + (2 * getWidth() * getHeight());
    }

    public double calculateVolume() {
        //lwh
        return getLength() * getWidth() * getHeight();
    }

    @Override
    public String toString() {
        return String.format("Surface Area - %.2f%nLateral Surface Area - %.2f%nVolume - %.2f",
                calculateSurfaceArea(),
                calculateLateralSurfaceArea(),
                calculateVolume());
    }
}
