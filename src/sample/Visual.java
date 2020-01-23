package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Visual extends Application {
    GradeTracker gradeTracker;
    Stage primaryStage;
    Text gpaText;
    Text averageText;
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage = primaryStage;
        // creating a grade tracker and drawing the gui
        gradeTracker = new GradeTracker();
        drawOrganizer(primaryStage);
    }

    public void drawOrganizer(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TrackerGui.fxml")); // this is a pane i think??

        Pane rootPane = new Pane();

        // sets listView location and the title text
        gradeTracker.drawListView();

        VBox vBox = new VBox();
        vBox.setLayoutX(236);
        vBox.setLayoutY(90);
        vBox.setMaxSize(250,400);
        vBox.setMinSize(250,400);
        vBox.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: black;");

//////////// DropShadows ////////////////
        DropShadow dropShadow = new DropShadow();
        dropShadow.setBlurType(BlurType.GAUSSIAN);
        dropShadow.setColor(Color.rgb(218, 204, 255));
        dropShadow.setHeight(15);
        dropShadow.setWidth(15);
        dropShadow.setRadius(15);

        DropShadow dropShadow2 = new DropShadow();
        dropShadow2.setBlurType(BlurType.GAUSSIAN);
        dropShadow2.setColor(Color.rgb(204, 255, 220));
        dropShadow2.setHeight(15);
        dropShadow2.setWidth(15);
        dropShadow2.setRadius(15);

//////////////// Text //////////////////
        Text title = new Text("Grade Tracker");
        title.setLayoutX(190);
        title.setLayoutY(50);
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
        title.setFill(Color.rgb(164, 189, 255));

        Text subTitle = new Text("Academic Performance");
        subTitle.setUnderline(true);
        subTitle.setLayoutX(20);
        subTitle.setLayoutY(340);
        subTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
        subTitle.setFill(Color.rgb(164, 189, 255));

        gpaText = new Text("Gpa : " + gradeTracker.getGpa());
        gpaText.setLayoutX(40);
        gpaText.setLayoutY(360);
        gpaText.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
        gpaText.setFill(Color.rgb(164, 189, 255));

        averageText = new Text("Average: " + gradeTracker.getTotalAverage());
        averageText.setLayoutX(40);
        averageText.setLayoutY(380);
        averageText.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
        averageText.setFill(Color.rgb(164, 189, 255));

/// Buttton ///////////////
        Button confirm = new Button();
        confirm.setText("Confirm");
        confirm.setPrefSize(60,25);
        confirm.setLayoutX(134);
        confirm.setLayoutY(270);
        //confirm.setBackground(new Background(new BackgroundFill(Color.rgb(225,245,245), CornerRadii.EMPTY, Insets.EMPTY)));
        confirm.setEffect(dropShadow);

///// Text Fields ////////////////
        TextField nameText = new TextField();
        nameText.setPrefSize(150,25);
        nameText.setLayoutX(50);
        nameText.setLayoutY(130);
        nameText.setPromptText("Name");
        nameText.setEffect(dropShadow);
        nameText.requestFocus();

        TextField gradeText = new TextField();
        gradeText.setPrefSize(150,25);
        gradeText.setLayoutX(50);
        gradeText.setLayoutY(180);
        gradeText.setPromptText("Grade");
        gradeText.setEffect(dropShadow);

        TextField weightText = new TextField();
        weightText.setPrefSize(150,25);
        weightText.setLayoutX(50);
        weightText.setLayoutY(230);
        weightText.setPromptText("Weight");
        weightText.setEffect(dropShadow);
        textFieldCode(nameText, gradeText, weightText, confirm);

//// Button Action
        confirm.setOnAction(event -> {
            try {
                setButtons(nameText, gradeText, weightText, gpaText, averageText);
                gradeTracker.calculateGpa();
                nameText.requestFocus();
            }catch(NumberFormatException e){
                System.out.println("Please submit the correct thing");
            }
        });
        confirm.setOnKeyPressed(event -> {
            try {
                setButtons(nameText, gradeText, weightText, gpaText, averageText);
                gradeTracker.calculateGpa();
                nameText.requestFocus();
            }catch(NumberFormatException e){
                System.out.println("Please submit the correct thing");
            }
        });


        rootPane.getChildren().addAll(title, vBox, gradeTracker.getListView());
        rootPane.getChildren().addAll(confirm, nameText, gradeText, weightText, subTitle );
        rootPane.getChildren().addAll(gpaText, averageText);
        courseView(nameText, gradeText, weightText, confirm);

        Scene scene = new Scene(rootPane, 700, 500);
        scene.setFill(Color.rgb(225,245,245));

        primaryStage.setScene(scene);
        primaryStage.setTitle("Grade Tracker");
        primaryStage.show();
    }

    public void textFieldCode(TextField nameText, TextField gradeText, TextField weightText, Button confirm){
        nameText.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.ENTER)){
                gradeText.requestFocus();
            }
        });

        gradeText.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.ENTER)){
                weightText.requestFocus();
            }
        });

        weightText.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.ENTER)){
                confirm.requestFocus();
            }
        });
    }

    public void courseView(TextField nameText, TextField gradeText, TextField weightText, Button confirm) {
        gradeTracker.getListView().getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Course>() {
            @Override
            public void changed(ObservableValue<? extends Course> observable,
                                Course oldValue, Course newValue) {
                // new value is the selected course
                textFieldCode(nameText, gradeText, weightText, confirm);
                nameText.setText(newValue.getCourseName());
                gradeText.setText(Double.toString(newValue.getCourseGrade()));
                weightText.setText(Double.toString(newValue.getCourseWeight()));
/*
theres a bug
after you select a course and change it while CLICKING confirm it changes the course
but if you go and try to add a course, then it changes that previously selected course instead of adding it
i think this is because i changed what confirm does but if i change it again in this function you cant
        edit anything else, you can only edit once
so i think the answer is to just change it after i call this function maybe?? // Nope this doesnt work
idk im really tired right now
maybe the answer is to get rid of the listener?? but then how would it know if its selected?? who knows
the bad answer is to just make a separate button or different text fields but thats dumbbbbb

 */
                confirm.setOnAction(event -> {
                    newValue.setCourseName(nameText.getText());
                    newValue.setCourseGrade(Double.parseDouble(gradeText.getText()));
                    newValue.setCourseWeight(Double.parseDouble(weightText.getText()));
                    refresh();
                    System.out.println("ugh");
                    nameText.clear();
                    weightText.clear();
                    gradeText.clear();
                    gradeTracker.getListView().getSelectionModel().clearSelection();
                });

/*
                confirm.setOnKeyPressed(event -> {
                    newValue.setCourseName(nameText.getText());
                    newValue.setCourseGrade(Double.parseDouble(gradeText.getText()));
                    newValue.setCourseWeight(Double.parseDouble(weightText.getText()));
                    refresh();
                    System.out.println("ugh");
                    nameText.clear();
                    weightText.clear();
                    gradeText.clear();
                    gradeTracker.getListView().getSelectionModel().clearSelection();
                });

 */


            }
        });
    }


    public void setButtons(TextField nameText, TextField gradeText, TextField weightText, Text gpaText, Text averageText){
        gradeTracker.infoUpdate(nameText, gradeText, weightText);
        gradeTracker.calculateGpa();
        gradeTracker.calculateAverage();
        nameText.clear();
        gradeText.clear();
        weightText.clear();
        refresh();
    }

    public void refresh(){
        gpaText.setText("Gpa : " + gradeTracker.getGpa());
        averageText.setText("Average: " + gradeTracker.getTotalAverage());
        gradeTracker.getListView().refresh();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
