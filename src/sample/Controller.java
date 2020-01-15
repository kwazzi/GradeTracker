package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

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
    private GradeTracker gradeTracker;



    public Controller(){
        gradeTracker = new GradeTracker();
    }

    @FXML
    void getData(ActionEvent event) {

    }

    @FXML
    void addCourse(ActionEvent event) {
        
    }
}


