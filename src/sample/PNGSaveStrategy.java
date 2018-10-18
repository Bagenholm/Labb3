package sample;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class PNGSaveStrategy implements SaveStrategy {

    @Override
    public void save(File file, Canvas canvas) {
        if(file != null){
            WritableImage wi = new WritableImage((int)canvas.getWidth(), (int)canvas.getHeight() /*(int)WIDTH,(int)HEIGHT */);
            try {
                ImageIO.write(SwingFXUtils.fromFXImage(canvas.snapshot(null,wi),null),"png",file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
