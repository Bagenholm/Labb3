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
    Model model = new Model();
    Shape tempShape;
    SaveContext saveContext = new SaveContext();
    public Controller() {

    }

    public void init() {
        saveContext.init();
        gc = canvas.getGraphicsContext2D();
        model.getObservableList().addListener((ListChangeListener<Shape>) c -> draw());
        shapeChoice.getItems().addAll("Circle", "Rectangle");

        widthField.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter()));
        heightField.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter()));

    }

    public void drawRadioClicked() {
        System.out.println("Draw mode");

        deselectAllShapes();
        draw();

        canvas.setOnMouseClicked( event  -> { int width = Integer.parseInt(widthField.getText());
            int height = Integer.parseInt(heightField.getText());
            Shape shape = ShapeFactory.getShape((String) shapeChoice.getValue(), canvas.getGraphicsContext2D(),
                (float)(event.getX() - width * 0.5), (float)(event.getY() - height * 0.5), width, height, colorPicker.getValue());
            model.getObservableList().add(shape);
        } );
    }

    public void selectRadioClicked() {
        System.out.println("Select mode");
        canvas.setOnMouseClicked( event -> {
            deselectAllShapes();
            model.getObservableList().stream().filter( shape -> shape.isInBounds(event.getX(), event.getY())).forEach(shape -> { tempShape = shape; } );
            tempShape.setSelected(true);

            colorPicker.setOnAction( (ActionEvent e) -> { tempShape.setColor(colorPicker.getValue()); draw(); });
            widthField.textProperty().addListener( (observable, oldValue, newValue) -> { tempShape.setWidth(Integer.parseInt(newValue));
                draw(); } );
            heightField.textProperty().addListener( (observable, oldValue, newValue) -> { tempShape.setHeight(Integer.parseInt(newValue));
                draw(); } );

            draw();

            widthField.setText(Integer.toString(tempShape.getWidth()));
            heightField.setText(Integer.toString(tempShape.getHeight()));
            colorPicker.setValue(tempShape.getColor());
        });
    }

    public void deselectAllShapes() {
        model.getObservableList().stream().filter( Shape::isSelected ).forEach(shape -> shape.setSelected(false));
    }

    public void draw() {
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (Shape shape: model.getObservableList()) {
            shape.draw();
        }
    }

    public void canvasClicked(MouseEvent event) {

    }

    public void clearCanvasAction(ActionEvent actionEvent) {
        model.getObservableList().clear();
    }

    public void save() {
        saveContext.save(canvas, model.getObservableList());
    }
}