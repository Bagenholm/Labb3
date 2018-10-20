package sample.Shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Oval extends Shape {

    public Oval(GraphicsContext gc, double x, double y, int width, int height, Color color) {
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

    @Override
    public String toString() {
        return "<ellipse cx=\"" + (x + width*0.5) + "\" cy=\"" + (y + height*0.5) + "\" rx=\"" + width*0.5
                + "\" ry=\"" + height*0.5 + "\" fill=\"" + toRGBCode(color) + "\" />";
    }
}
