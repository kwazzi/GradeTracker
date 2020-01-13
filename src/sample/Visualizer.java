package sample;
// https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ListView.html

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.IOException;

public class Visualizer {


    public Visualizer(Stage primaryStage) throws IOException {

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

        rootPane.getChildren().add(root);
        rootPane.getChildren().add(vBox);
        rootPane.getChildren().add(gradeTracker.getListView());

        Scene scene = new Scene(rootPane, 500, 500);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Grade Tracker");
        primaryStage.show();
    }
        public ListView updateList(Pane rootPane, GradeTracker gradeTracker){
            rootPane.getChildren().remove(gradeTracker.getListView());
            rootPane.getChildren().add(gradeTracker.getListView());
            return gradeTracker.getListView();
        }

}
