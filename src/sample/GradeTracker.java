package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class GradeTracker {
    ArrayList<Course> courses = new ArrayList<>();
    ObservableList<Course> names = FXCollections.observableArrayList(new Course("history", 98, 7));
    ListView<Course> listView = new ListView<>();

    public GradeTracker(){


    }

    public void controllerUpdate(TextField nameText, TextField gradeText, TextField weightText){

        String thisName = nameText.getText();
        int thisGrade = Integer.parseInt(gradeText.getText());
        int thisWeight = Integer.parseInt(weightText.getText());

        Course course = new Course(thisName, thisGrade, thisWeight);
        courses.add(course);
        //System.out.println(course.getCourseName() + " " + course.getCourseGrade() + " " + course.getCourseWeight());
        getNames().add(course);
        setTheList();
        for(int i = 0; i < getNames().size(); i ++) {
            System.out.println(getNames().get(i));
        }
        updateList();
    }

    public void setTheList(){
        listView.setItems(names);
    }

    public ListView updateList(){
        ListView<Course> current = new ListView<>();
        listView.setItems(names);
        listView = current;

        return listView;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public void draw(){
        setTheList();
        listView.setLayoutX(236);
        listView.setLayoutY(90);
    }

    public ListView<Course> getListView() {
        return listView;
    }

    public void setListView(ListView<Course> listView) {
        this.listView = listView;
    }

    public void setNames(ObservableList<Course> names) {
        this.names = names;
    }

    public ObservableList<Course> getNames() {
        return names;
    }
}
