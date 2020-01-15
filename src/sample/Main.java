package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Visual extends Application {
// maybe put the start function inside of visualizer so you can use primary stage in other parts of the program
    @Override
    public void start(Stage primaryStage) throws Exception{
        drawOrganizer(primaryStage);
    }

    public void drawOrganizer(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TrackerGui.fxml")); // this is a pane i think??
        Pane rootPane = new Pane();
        GradeTracker gradeTracker = new GradeTracker();
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
        // USE LISTVIEW ////////////////////////
        Text text = new Text("Grade Tracker");
        text.setLayoutX(80);
        text.setLayoutY(50);
        text.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
        rootPane.getChildren().add(text);
        rootPane.getChildren().addAll(root);
        rootPane.getChildren().add(vBox);
        rootPane.getChildren().add(gradeTracker.getListView());

        Scene scene = new Scene(rootPane, 500, 500);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Grade Tracker");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
