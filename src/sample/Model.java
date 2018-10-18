package sample;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Shapes.Shape;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private StringProperty text;
    private BooleanProperty disabled;
    private List<Shape> shapes = new ArrayList<>();
    private ObservableList<Shape> observableList = FXCollections.observableList(shapes);

    public Model () {
        text = new SimpleStringProperty();
        disabled = new SimpleBooleanProperty();
    }

    public ObservableList<Shape> getObservableList() {
        return observableList;
    }
}