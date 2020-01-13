package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

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
            Course course = new Course(nameText.getText(), Integer.parseInt(gradeText.getText()), Integer.parseInt(weightText.getText()));
            gradeTracker.getCourses().add(course);
            System.out.println(course.getCourseName() + " " + course.getCourseGrade() + " " + course.getCourseWeight());

        }catch(Exception e){

        }

        // finalButton.setBackground(new Background((new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY))));
    }

}

