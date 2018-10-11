package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.paint.Color;

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

    public Controller() {

    }

    public void init() {
        draw();
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shapeCircle = shapeFactory.getShape(shapeType);
        shapeCircle.draw();
    }

    public void draw() {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillRect(0, 0, 366, 399);


    }


}
