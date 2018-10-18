package sample;

import javafx.collections.ObservableList;
import javafx.scene.canvas.Canvas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SVGSaveStrategy implements SaveStrategy {

    @Override
    public void save(File file, Canvas canvas, ObservableList<Shape> shapes) {
        System.out.println("SVG save");

        try {
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("<svg height=\"" +canvas.getHeight() + "\" width=\"" + canvas.getWidth() + "\">");
            for (Shape shape : shapes ) {
                bw.write(shape.toString());
                bw.write("\n");
            }
            bw.write("</svg>");
            bw.close();

        } catch (IOException e) {

        }
    }
}