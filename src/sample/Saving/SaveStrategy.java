package sample.Saving;

import javafx.collections.ObservableList;
import javafx.scene.canvas.Canvas;
import sample.Shapes.Shape;

import java.io.File;

interface SaveStrategy {
    void save(File file, Canvas canvas, ObservableList<Shape> shapes);
}
