package sample;

import javafx.scene.canvas.Canvas;

import java.io.File;

public class SVGSaveStrategy implements SaveStrategy {

    @Override
    public void save(File file, Canvas canvas) {
        System.out.println("SVG save");

    }
}