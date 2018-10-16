package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape implements Drawable {

    double x, y;
    int width, height;
    Color color;
    GraphicsContext gc;

    public Shape (GraphicsContext gc, double x, double y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.gc = gc;
        this.width = width;
        this.height = height;
    }

    boolean selected = false;

    public boolean isInBounds(double xClick, double yClick) {
        double xMax, yMax;
        xMax = x + width;
        yMax = y + height;

        if ( (xClick > x && xClick < xMax) && (yClick > y && yClick < yMax) ) {
            return true;
        }
        return false;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public GraphicsContext getGc() {
        return gc;
    }

    public void setGc(GraphicsContext gc) {
        this.gc = gc;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void draw() {

    }
}
