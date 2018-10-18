package sample;

import javafx.scene.canvas.Canvas;
import javafx.stage.FileChooser;

import java.io.File;



public class SaveContext {

    PNGSaveStrategy png;
    SVGSaveStrategy svg;

    public void init() {
        png = new PNGSaveStrategy();
        svg = new SVGSaveStrategy();
    }

    void save(Canvas canvas) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG", "*.png"));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("SVG", "*.svg"));
        fc.setTitle("Save to..");
        File file = fc.showSaveDialog(null);

        if (fc.getSelectedExtensionFilter().getDescription().equalsIgnoreCase("PNG")) {
            png.save(file, canvas);
        } else if (fc.getSelectedExtensionFilter().getDescription().equalsIgnoreCase("SVG")) {
            svg.save(file, canvas);
        }
    }
}
