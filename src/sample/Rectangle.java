package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Shape {

    public Rectangle(GraphicsContext gc, double x, double y, int width, int height, Color color) {
        super(gc, x, y, width, height, color);
    }

    @Override
    public void draw() {
        gc.setFill(color);
        gc.fillRect(x, y, width, height);
        if (selected) {
            gc.setLineWidth(5);
            gc.setStroke(Color.BLUE);
            gc.strokeRect(x, y, width, height);
        }
    }
}
