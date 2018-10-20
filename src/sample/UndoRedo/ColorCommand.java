package sample.UndoRedo;

import javafx.scene.paint.Color;
import sample.Shapes.Shape;

public class ColorCommand implements Command {

    private Shape shape;
    private Color oldColor;
    private Color newColor;

    public ColorCommand(Shape shape, Color newColor) {
        this.shape = shape;
        this.newColor = newColor;
    }

    @Override
    public void execute() {
        oldColor = shape.getColor();

        shape.setColor(newColor);
    }

    @Override
    public void unExecute() {
        shape.setColor(oldColor);
    }
}
