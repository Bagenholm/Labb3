package sample.UndoRedo;

import sample.Shapes.Shape;

public class HeightCommand implements Command {

    private int height, oldHeight;
    private Shape shape;


    public HeightCommand(Shape shape, int height) {
        this.shape = shape;
        this.height = height;
    }

    @Override
    public void execute() {
        this.oldHeight = shape.getHeight();

        shape.setHeight(height);
    }

    @Override
    public void unExecute() {
        shape.setHeight(oldHeight);
    }
}
