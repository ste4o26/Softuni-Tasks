package p01_SingleResponsibility.p01_DrawingShape.darwing_manager;

import p01_SingleResponsibility.p01_DrawingShape.shapes.Shape;

public class DrawingManagerImpl implements DrawingManager {

    public DrawingManagerImpl() {
    }

    @Override
    public void draw(Shape shape) {
        shape.draw();
    }
}
