package sample;

import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class PNGSave implements SaveStrategy {

    @Override
    public void save(File file, Canvas canvas, ObservableList<Shape> shapes) {
        WritableImage wi = new WritableImage((int)canvas.getWidth(), (int)canvas.getHeight());
        Image image = canvas.snapshot(null, wi);

        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                if(file != null){
                    try {
                        ImageIO.write(SwingFXUtils.fromFXImage(image,null),"png",file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }
        };

        Thread thread = new Thread(task);
        thread.setDaemon(true);
        thread.start();
    }

}
