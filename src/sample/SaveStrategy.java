package sample;

import javafx.collections.ObservableList;
import javafx.scene.canvas.Canvas;

import java.io.File;

public interface SaveStrategy {
    void save(File file, Canvas canvas, ObservableList<Shape> shapes);
}
