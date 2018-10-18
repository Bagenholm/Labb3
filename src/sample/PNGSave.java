package sample;

import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class PNGSave implements SaveStrategy {

    @Override
    public void save(File file, Canvas canvas, ObservableList<Shape> shapes) {
        if(file != null){
            WritableImage wi = new WritableImage((int)canvas.getWidth(), (int)canvas.getHeight());
            try {
                ImageIO.write(SwingFXUtils.fromFXImage(canvas.snapshot(null,wi),null),"png",file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
