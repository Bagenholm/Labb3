package sample.Shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class ShapeFactory {
    private GraphicsContext graphicsContext;

    public ShapeFactory(GraphicsContext graphicsContext){
        this.graphicsContext = graphicsContext;
    }

    public static Shape getShape(String shapeType, GraphicsContext graphicsContext, float x, float y, int width, int height, Color color) {
        if(shapeType.equalsIgnoreCase("OVAL")) {
            return new Oval(graphicsContext, x, y, width, height, color);
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle(graphicsContext, x, y, width, height, color);
        }

        return null;
    }
}
