package sample;

import javafx.scene.canvas.Canvas;

import java.io.File;

public interface SaveStrategy {
    void save(File file, Canvas canvas);
}
