package p01_SingleResponsibility.p01_DrawingShape;

import p01_SingleResponsibility.p01_DrawingShape.darwing_manager.DrawingManager;
import p01_SingleResponsibility.p01_DrawingShape.darwing_manager.DrawingManagerImpl;
import p01_SingleResponsibility.p01_DrawingShape.shapes.Rectangle;
import p01_SingleResponsibility.p01_DrawingShape.shapes.Shape;

public class Main {
    public static void main(String[] args) {
        DrawingManager drawingManager = new DrawingManagerImpl();
        Shape rectangle = new Rectangle(2, 3);
        drawingManager.draw(rectangle);
    }
}
