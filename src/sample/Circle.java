package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle implements Shape {

    double x, y;
    int width, height;
    Color color;
    GraphicsContext graphicsContext;

    public Circle(GraphicsContext graphicsContext, double x, double y, int width, int height, Color color) {
        this.graphicsContext = graphicsContext;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public void draw() {
        graphicsContext.setFill(color);
        graphicsContext.fillOval(x, y, width, height);
    }

}
