package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle implements Shape {

    double x, y;
    int width, height;
    Color color;
    GraphicsContext gc;

    public Rectangle(GraphicsContext gc, double x, double y, int width, int height, Color color) {
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
        gc.fillRect(x, y, width, height);
    }


}