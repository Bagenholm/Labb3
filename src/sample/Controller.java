package sample;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
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
    @FXML
    TextField widthField;
    @FXML
    TextField heightField;

    GraphicsContext graphicsContext;// = canvas.getGraphicsContext2D();
    ShapeFactory shapeFactory;


    Model model = new Model();
     //TODO: Connect to shapeChoice list

    public Controller() {

    }

    public void init() {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        model.getObservableList().addListener((ListChangeListener<Shape>) c -> draw());
        shapeFactory = new ShapeFactory(graphicsContext);
        shapeChoice.getItems().add("Circle");
        shapeChoice.getItems().add("Rectangle");

    }

    public void draw() {
        canvas.getGraphicsContext2D().setFill(Color.WHITE);
        canvas.getGraphicsContext2D().fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        canvas.getGraphicsContext2D().strokeRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (Shape shape: model.getObservableList()) {
            shape.draw();
        }
    }

    public void canvasClicked(MouseEvent event) {  //TODO: Change mouse event based on draw or select.
        int width = Integer.parseInt(widthField.getText());
        int height = Integer.parseInt(heightField.getText());
        Shape shape = shapeFactory.getShape((String) shapeChoice.getValue(), canvas.getGraphicsContext2D(),
                (float)event.getX() - width * 0.5f, (float)event.getY() - height*0.5f,width, height, colorPicker.getValue());
        model.getObservableList().add(shape);
    }
}