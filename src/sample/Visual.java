package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
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

        Button confirm = new Button();
        confirm.setText("Confirm");
        confirm.setPrefSize(60,25);
        confirm.setLayoutX(134);
        confirm.setLayoutY(270);
        //confirm.setBackground(new Background(new BackgroundFill(Color.rgb(225,245,245), CornerRadii.EMPTY, Insets.EMPTY)));
        confirm.setEffect(dropShadow);

        //////////// TextFields /////////////////

        TextField nameText = new TextField();
        nameText.setPrefSize(150,25);
        nameText.setLayoutX(50);
        nameText.setLayoutY(130);
        nameText.setPromptText("Name");
        nameText.setEffect(dropShadow);

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

        confirm.setOnAction(event -> {
            try {
                setButtons(nameText, gradeText, weightText);
            }catch(NumberFormatException e){
                System.out.println("Please submit the correct thing");
            }
        });

        rootPane.getChildren().addAll(title, root, vBox, gradeTracker.getListView());
        rootPane.getChildren().addAll(confirm, nameText, gradeText, weightText,subTitle );

        Scene scene = new Scene(rootPane, 700, 500);
        scene.setFill(Color.rgb(225,245,245));

        primaryStage.setScene(scene);
        primaryStage.setTitle("Grade Tracker");
        primaryStage.show();
    }

    public void setButtons(TextField nameText, TextField gradeText, TextField weightText){
        gradeTracker.infoUpdate(nameText, gradeText, weightText);
        gradeTracker.calculateGpa();
        gradeTracker.calculateAverage();
        System.out.println(gradeTracker.getGpa() + "   " + gradeTracker.getTotalAverage());
        nameText.clear();
        gradeText.clear();
        weightText.clear();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
