package sample.UndoRedo;

import sample.Shapes.Shape;

public class WidthCommand implements Command {

    private int width, oldWidth;
    private Shape shape;


    public WidthCommand(Shape shape, int width) {
        this.shape = shape;
        this.width = width;
    }

    @Override
    public void execute() {
        this.oldWidth = shape.getWidth();

        shape.setWidth(width);
    }

    @Override
    public void unExecute() {
        shape.setWidth(oldWidth);
    }
}
