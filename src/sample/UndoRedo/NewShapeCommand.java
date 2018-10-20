package sample.UndoRedo;

import javafx.collections.ObservableList;
import sample.Shapes.Shape;

public class NewShapeCommand implements Command {

    private ObservableList<Shape> shapes;
    private Shape shape;

    public NewShapeCommand(ObservableList<Shape> shapes, Shape shape) {
       this.shapes = shapes;
       this.shape = shape;
    }

    @Override
    public void execute() {
        shapes.add(shape);
    }

    @Override
    public void unExecute() {
        shapes.remove(shape);
    }
}
