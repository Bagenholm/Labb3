package sample.Saving;

import javafx.collections.ObservableList;
import javafx.scene.canvas.Canvas;
import javafx.stage.FileChooser;
import sample.Shapes.Shape;

import java.io.File;

public class SaveContext {

    private PNGSave png;
    private SVGSave svg;

    public void init() {
        png = new PNGSave();
        svg = new SVGSave();
    }

    public void save(Canvas canvas, ObservableList<Shape> shapes) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG", "*.png"));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("SVG", "*.svg"));
        fc.setTitle("Save to..");
        File file = fc.showSaveDialog(null);

        if (fc.getSelectedExtensionFilter().getDescription().equalsIgnoreCase("PNG")) {
            png.save(file, canvas, shapes);
        } else if (fc.getSelectedExtensionFilter().getDescription().equalsIgnoreCase("SVG")) {
            svg.save(file, canvas, shapes);
        }
    }
}
