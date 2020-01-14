package sample;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Visualizer visualizer = new Visualizer(primaryStage);
        visualizer.drawOrganizer();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
