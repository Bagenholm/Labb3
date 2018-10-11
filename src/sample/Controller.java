package sample;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;

public class Controller {
    @FXML
    Button saveButton;
    @FXML
    Button loadButton;
    @FXML
    Canvas canvas;
    @FXML
    RadioButton drawRadio;
    @FXML
    RadioButton selectRadio;
    @FXML
    ChoiceBox shapeChoice;
    @FXML
    ColorPicker colorPicker;
    @FXML
    Button deleteButton;
    @FXML
    Button clearButton;

    String shapeType;
    Model model = new Model();

    public Controller() {

    }

    public void init() {
        draw();
        ShapeFactory shapeFactory = new ShapeFactory(); //TODO: Connect to shapeChoice list
        model.getObservableList().addListener((ListChangeListener<Point2D>) c -> draw());
    }

    public void draw() {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        graphicsContext.strokeRect(0, 0, canvas.getWidth(), canvas.getHeight());

        Paint p = colorPicker.getValue();

        graphicsContext.setFill(p);
        for (Point2D point : model.getObservableList()) {
            graphicsContext.fillRect(point.getX(), point.getY(), 20, 20); //TODO: Offset for x and y at half width and height, width and height connected to fields.
                                                                                //TODO: Change fillRect to be the right shape.
        }
    }

    public void canvasClicked(MouseEvent event) {  //TODO: Change mouse event based on draw or select.
        Point2D point = new Point2D(event.getX(), event.getY());
        model.getObservableList().add(point);

    }
}