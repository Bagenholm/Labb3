package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class ShapeFactory {
    GraphicsContext graphicsContext;

    public ShapeFactory(GraphicsContext graphicsContext){
        this.graphicsContext = graphicsContext;
    }

    public static Shape getShape(String shapeType, GraphicsContext graphicsContext, float x, float y, int width, int height, Color color) {
        if(shapeType.equalsIgnoreCase("CIRCLE")) {
            System.out.println("Making circle");
            return new Circle(graphicsContext, x, y, width, height, color);
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle(graphicsContext, x, y, width, height, color);
        }

        return null;
    }
}
