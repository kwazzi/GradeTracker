package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


public class Controller {

    @FXML
    private TextField gradeText;
    @FXML
    private Pane fxPane;
    @FXML
    private VBox fxVbox;
    @FXML
    private TextField weightText;
    @FXML
    private Button finalButton;
    @FXML
    private TextField nameText;
    private GradeTracker gradeTracker = new GradeTracker();



    public Controller(){

    }

    @FXML
    void getData(ActionEvent event) {

    }

    @FXML
    void addCourse(ActionEvent event) {
        try {
             gradeTracker.controllerUpdate(nameText, gradeText, weightText);

        }catch(Exception e){

        }

        // finalButton.setBackground(new Background((new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY))));
    }

}

