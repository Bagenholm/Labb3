[33mcommit bcea62139a3243921145529f18174f4181307cfc[m[33m ([m[1;36mHEAD -> [m[1;32mShapeClassTest[m[33m)[m
Author: Patrik <sputtrosa@gmail.com>
Date:   Thu Oct 18 13:07:32 2018 +0200

    Adding save as png functionality through strategy pattern

[1mdiff --git a/src/sample/pngSaveStrategy.java b/src/sample/pngSaveStrategy.java[m
[1mindex 5901228..67345f3 100644[m
[1m--- a/src/sample/pngSaveStrategy.java[m
[1m+++ b/src/sample/pngSaveStrategy.java[m
[36m@@ -1,9 +1,26 @@[m
 package sample;[m
 [m
[31m-public class pngSaveStrategy implements SaveStrategy {[m
[32m+[m[32mimport javafx.embed.swing.SwingFXUtils;[m
[32m+[m[32mimport javafx.scene.canvas.Canvas;[m
[32m+[m[32mimport javafx.scene.image.Image;[m
[32m+[m[32mimport javafx.scene.image.WritableImage;[m
 [m
[31m-    @Override[m
[31m-    public void save() {[m
[32m+[m[32mimport javax.imageio.ImageIO;[m
[32m+[m[32mimport java.io.File;[m
[32m+[m[32mimport java.io.IOException;[m
[32m+[m
[32m+[m[32mpublic class PNGSaveStrategy implements SaveStrategy {[m
 [m
[32m+[m[32m    @Override[m
[32m+[m[32m    public void save(File file, Canvas canvas) {[m
[32m+[m[32m        if(file != null){[m
[32m+[m[32m            WritableImage wi = new WritableImage((int)canvas.getWidth(), (int)canvas.getHeight() /*(int)WIDTH,(int)HEIGHT */);[m
[32m+[m[32m            try {[m
[32m+[m[32m                ImageIO.write(SwingFXUtils.fromFXImage(canvas.snapshot(null,wi),null),"png",file);[m
[32m+[m[32m            } catch (IOException e) {[m
[32m+[m[32m                e.printStackTrace();[m
[32m+[m[32m            }[m
[32m+[m[32m        }[m
     }[m
[31m-}[m
\ No newline at end of file[m
[32m+[m
[32m+[m[32m}[m
