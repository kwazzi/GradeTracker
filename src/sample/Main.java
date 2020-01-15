package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Visual extends Application {
    GradeTracker gradeTracker;
    @Override
    public void start(Stage primaryStage) throws Exception{
        // creating a grade tracker and drawing the gui
        gradeTracker = new GradeTracker();
        drawOrganizer(primaryStage);
    }

    public void drawOrganizer(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TrackerGui.fxml")); // this is a pane i think??

        Pane rootPane = new Pane();
        // sets listView location and the title text
        gradeTracker.draw();

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

        Text text = new Text(gradeTracker.getText());
        text.setLayoutX(80);
        text.setLayoutY(50);
        text.setFont(Font.font("Verdana", FontWeight.BOLD, 40));

        Button confirm = new Button();
        confirm.setText("Confirm");
        confirm.setPrefSize(60,25);
        confirm.setLayoutX(134);
        confirm.setLayoutY(270);

        //////////// TextFields /////////////////

        TextField nameText = new TextField();
        nameText.setPrefSize(150,25);
        nameText.setLayoutX(50);
        nameText.setLayoutY(130);
        nameText.setPromptText("Name");

        TextField gradeText = new TextField();
        gradeText.setPrefSize(150,25);
        gradeText.setLayoutX(50);
        gradeText.setLayoutY(180);
        gradeText.setPromptText("Grade");

        TextField weightText = new TextField();
        weightText.setPrefSize(150,25);
        weightText.setLayoutX(50);
        weightText.setLayoutY(230);
        weightText.setPromptText("Weight");

        confirm.setOnAction(event -> {
            try {
                gradeTracker.infoUpdate(nameText, gradeText, weightText);
                gradeTracker.calculateGpa();
                nameText.clear();
                gradeText.clear();
                weightText.clear();
            }catch(NumberFormatException e){
                System.out.println("Please submit the correct thing");
            }
        });

        rootPane.getChildren().addAll(text, root, vBox, gradeTracker.getListView());
        rootPane.getChildren().addAll(confirm, nameText, gradeText, weightText);

        Scene scene = new Scene(rootPane, 500, 500);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Grade Tracker");
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
