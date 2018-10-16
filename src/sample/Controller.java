package sample;

import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.converter.IntegerStringConverter;

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
    @FXML
    ChoiceBox shapeList;

    GraphicsContext gc;
    ShapeFactory shapeFactory;
    Model model = new Model();

    public Controller() {

    }

    public void init() {
        gc = canvas.getGraphicsContext2D();
        model.getObservableList().addListener((ListChangeListener<Shape>) c -> draw());
        shapeFactory = new ShapeFactory(gc);
        shapeChoice.getItems().addAll("Circle", "Rectangle");

        widthField.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter()));
        heightField.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter()));
    }

    public void drawRadioClicked() {
        System.out.println("Draw mode");
        canvas.setOnMouseClicked( event  -> { int width = Integer.parseInt(widthField.getText());
        int height = Integer.parseInt(heightField.getText());
        Shape shape = shapeFactory.getShape((String) shapeChoice.getValue(), canvas.getGraphicsContext2D(),
                (float)(event.getX() - width * 0.5), (float)(event.getY() - height * 0.5), width, height, colorPicker.getValue());
        model.getObservableList().add(shape);
        } );
    }
//
    public void selectRadioClicked() {
        System.out.println("Select mode");
        canvas.setOnMouseClicked( event -> {

            for (Shape shape : model.getObservableList()) {
                if (shape.isInBounds(event.getX(), event.getY())) {
                    System.out.println(shape.getClass().getSimpleName() + " is clicked!");
                }
            }
        });
    }

    public void draw() {
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.strokeRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (Shape shape: model.getObservableList()) {
            shape.draw();
        }
    }

    public void canvasClicked(MouseEvent event) {

    }

    public void clearCanvasAction(ActionEvent actionEvent) {
        model.getObservableList().clear();
    }

}