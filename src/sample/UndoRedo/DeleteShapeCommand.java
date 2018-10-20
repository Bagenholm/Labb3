package sample.UndoRedo;

import javafx.collections.ObservableList;
import sample.Shapes.Shape;

public class DeleteShapeCommand implements Command {

    private ObservableList<Shape> shapes;
    private Shape shape;

    public DeleteShapeCommand(ObservableList<Shape> shapes, Shape shape) {
        this.shapes = shapes;
        this.shape = shape;
    }

    @Override
    public void execute() {
        shapes.remove(shape);
    }

    @Override
    public void unExecute() {
        shapes.add(shape);
    }
}
