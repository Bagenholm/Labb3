package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Shape {

    public Circle(GraphicsContext gc, double x, double y, int width, int height, Color color) {
        super(gc, x, y, width, height, color);
    }

    @Override
    public void draw() {
        gc.setFill(color);
        gc.fillOval(x, y, width, height);
        if (selected) {
            gc.setLineWidth(5);
            gc.setStroke(Color.BLUE);
            gc.strokeOval(x, y, width, height);
        }
    }
}
