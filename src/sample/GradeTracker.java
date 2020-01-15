package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.util.ArrayList;

public class GradeTracker {
    ArrayList<Course> courses = new ArrayList<>();
    ObservableList<Course> names = FXCollections.observableArrayList();
    ListView<Course> listView = new ListView<>();
    String text;

    public GradeTracker(){
        listView.setItems(names);
    }

    public void infoUpdate(TextField nameText, TextField gradeText, TextField weightText){
            String thisName = nameText.getText();
            int thisGrade = Integer.parseInt(gradeText.getText());
            int thisWeight = Integer.parseInt(weightText.getText());
            controllerUpdate(thisName, thisGrade, thisWeight);
    }


    public void controllerUpdate(String name, int grade, int weight ){
        Course course = new Course(name, grade, weight);
        courses.add(course);
        names.add(course);
        listView.setItems(names);
        for(int i = 0; i < names.size(); i ++) {
            System.out.println(listView.getItems().get(i));
        }
        text = "Ugh";
        System.out.println(text);
        course.drawCourse();
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public void draw(){
        //setTheList();
        listView.setLayoutX(236);
        listView.setLayoutY(90);
        text = "Grade Tracker";
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


