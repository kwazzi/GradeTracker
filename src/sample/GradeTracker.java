package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GradeTracker {
    ArrayList<Course> courses = new ArrayList<>();
    ObservableList<String> names = FXCollections.observableArrayList();
    ListView<String> listView = new ListView<String>();

    public GradeTracker(){

    }

    public void setTheList(){
        for(int i = 0; i < courses.size(); i ++){
            names.add(courses.get(i).getCourseName());
        }
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

    public ListView<String> getListView() {
        return listView;
    }

    public void setListView(ListView<String> listView) {
        this.listView = listView;
    }

    public void setNames(ObservableList<String> names) {
        this.names = names;
    }

    public ObservableList<String> getNames() {
        return names;
    }
}
