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
import sample.Shapes.Shape;
import sample.Shapes.ShapeFactory;
import sample.Saving.*;
import sample.UndoRedo.*;

public class Controller {
    @FXML
    Button saveButton;
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
    Button undoButton;
    @FXML
    Button redoButton;

    private GraphicsContext gc;
    private Model model = new Model();
    private Shape tempShape;
    private SaveContext saveContext = new SaveContext();
    private CommandManager commands = new CommandManager();

    public Controller() {

    }

    public void init() {
        saveContext.init();
        gc = canvas.getGraphicsContext2D();
        model.getObservableList().addListener((ListChangeListener<Shape>) c -> draw());
        shapeChoice.getItems().addAll("Oval", "Rectangle");
        shapeChoice.setValue("Oval");

        widthField.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter()));
        heightField.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter()));

        colorPicker.setOnAction( (ActionEvent e) -> { if (tempShape != null) { commands.doCommand(new ColorCommand(tempShape, colorPicker.getValue()));
        draw();} });

        widthField.textProperty().addListener( (observable, oldValue, newValue) -> {
            if (tempShape != null) { commands.doCommand(new WidthCommand(tempShape, Integer.parseInt(newValue)));
            draw(); } });

        heightField.textProperty().addListener( (observable, oldValue, newValue) -> {
            if (tempShape != null) { commands.doCommand(new HeightCommand(tempShape, Integer.parseInt(newValue))); }
            draw(); } );

    }

    public void drawRadioClicked() {
        deselectAllShapes();
        draw();
        canvas.setOnMouseClicked( event  -> { int width = Integer.parseInt(widthField.getText());
            int height = Integer.parseInt(heightField.getText());

            Shape shape = ShapeFactory.getShape((String) shapeChoice.getValue(), canvas.getGraphicsContext2D(),
                (float)(event.getX() - width * 0.5), (float)(event.getY() - height * 0.5), width, height, colorPicker.getValue());

            commands.doCommand(new NewShapeCommand(model.getObservableList(), shape));
        } );
    }

    public void selectRadioClicked() {
        canvas.setOnMouseClicked( event -> {
            deselectAllShapes();
            model.getObservableList().stream().filter( shape -> shape.isInBounds(event.getX(), event.getY())).forEach(shape -> tempShape = shape);
            if (tempShape != null) {
                tempShape.setSelected(true);
            }

            draw();

            widthField.setText(Integer.toString(tempShape.getWidth()));
            heightField.setText(Integer.toString(tempShape.getHeight()));
            colorPicker.setValue(tempShape.getColor());
        });
    }

    private void deselectAllShapes() {
        model.getObservableList().stream().filter( Shape::isSelected ).forEach(shape -> shape.setSelected(false));
        tempShape = null;
    }

    private void draw() {
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (Shape shape: model.getObservableList()) {
            shape.draw();
        }
    }

    public void canvasClicked(MouseEvent event) {

    }

    public void deleteSelectedShape() {
        commands.doCommand(new DeleteShapeCommand(model.getObservableList(), tempShape));
    }

    public void clearCanvasAction(ActionEvent actionEvent) {
        model.getObservableList().clear();
    }

    public void save() {
        saveContext.save(canvas, model.getObservableList());
    }

    public void undo() {
        commands.undo();
        draw();
    }

    public void redo() {
        commands.redo();
        draw();
    }
}