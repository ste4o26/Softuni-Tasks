package point_in_rectangle;

public class Rectangle {

    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean containsPoint(Point point) {
        boolean isXInRectangle = point.getCoordinateX() >= this.bottomLeft.getCoordinateX() &&
                point.getCoordinateX() <= this.topRight.getCoordinateX();

        boolean isYInRectangle = point.getCoordinateY() >= this.bottomLeft.getCoordinateY() &&
                point.getCoordinateY() <= this.topRight.getCoordinateY();

        if (isXInRectangle && isYInRectangle) {
            return true;
        } else {
            return false;
        }
    }
}
