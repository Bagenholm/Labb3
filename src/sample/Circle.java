package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Shape {

    double x, y;
    int width, height;
    Color color;
    GraphicsContext gc;
    boolean selected = false;

    public Circle(GraphicsContext gc, double x, double y, int width, int height, Color color) {
        super(gc, x, y, width, height, color);
        this.gc = gc;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;

    }

    @Override
    public void draw() {
        gc.setFill(color);
        gc.fillOval(x, y, width, height);
    }
}
