package sample;

import javafx.collections.ObservableList;
import javafx.scene.canvas.Canvas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SVGSave implements SaveStrategy {

    @Override
    public void save(File file, Canvas canvas, ObservableList<Shape> shapes) {
        System.out.println("SVG save");

        try {
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
                    "\n<svg height=\"" +canvas.getHeight() + "\" width=\"" + canvas.getWidth() + "\" xmlns=\"http://www.w3.org/2000/svg\">");
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