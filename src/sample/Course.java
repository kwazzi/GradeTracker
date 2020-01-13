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




    public Controller(){

    }

    @FXML
    void getData(ActionEvent event) {

    }

    @FXML
    void addCourse(ActionEvent event) {
        try {
            System.out.println("ahaha");
            GradeTracker gradeTracker = new GradeTracker();
            String thisName = nameText.getText();
            int thisGrade = Integer.parseInt(gradeText.getText());
            int thisWeight = Integer.parseInt(weightText.getText());
            Course course = new Course(thisName, thisGrade, thisWeight);
            gradeTracker.getCourses().add(course);
            System.out.println(gradeTracker.getCourses().get(0).getCourseName());
            //System.out.println(course.getCourseName() + " " + course.getCourseGrade() + " " + course.getCourseWeight());
            gradeTracker.getNames().add(course.getCourseName());
            gradeTracker.getListView().setItems(gradeTracker.getNames());
            System.out.println(gradeTracker.getNames().get(0));

        }catch(Exception e){

        }

        // finalButton.setBackground(new Background((new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY))));
    }

}



