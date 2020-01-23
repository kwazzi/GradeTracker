package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class GradeTracker {
    ArrayList<Course> courses = new ArrayList<>();
    ObservableList<Course> names = FXCollections.observableArrayList();
    ListView<Course> listView = new ListView<>();
    double gpa;
    double totalAverage;

    public GradeTracker(){
        listView.setItems(names);
    }

    public void calculateGpa(){
        double grade;
        double currentTotal = 0;
        Course thisCourse;

        for (int i = 0; i < courses.size(); i++) {
            thisCourse = courses.get(i);
            grade = (thisCourse.getCourseGrade() * thisCourse.getCourseWeight()) / 100;
            currentTotal = grade + currentTotal;
        }
        gpa = currentTotal / courses.size();
        setGpa(gpa);
    }

    public void calculateAverage(){
        // academic performance
        double grade;
        double currentTotal = 0;
        Course thisCourse;

        for(int i = 0; i < courses.size(); i ++){
            thisCourse = courses.get(i);
            grade = thisCourse.getCourseGrade();
            currentTotal = currentTotal + grade;
        }
        totalAverage = currentTotal / courses.size();
        setTotalAverage(totalAverage);
    }

    public void infoUpdate(TextField nameText, TextField gradeText, TextField weightText){
        String thisName = nameText.getText();
        int thisGrade = Integer.parseInt(gradeText.getText());
        int thisWeight = Integer.parseInt(weightText.getText());
        controllerUpdate(thisName, thisGrade, thisWeight);
    }

    public void controllerUpdate(String name, int grade, int weight ) {
        Course course = new Course(name, grade, weight);
        courses.add(course);
        names.add(course);
        listView.setItems(names);
        for (int i = 0; i < names.size(); i++) {

        }
    }

    public void drawListView(){
        listView.setLayoutX(236);
        listView.setLayoutY(90);
        DropShadow dropShadow = new DropShadow();
        dropShadow.setBlurType(BlurType.GAUSSIAN);
        dropShadow.setColor(Color.rgb(204, 236, 255));
        dropShadow.setHeight(15);
        dropShadow.setWidth(15);
        dropShadow.setRadius(15);
        listView.setEffect(dropShadow);
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
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

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        gpa = Math.round(gpa * 100.0) / 100.0;
        this.gpa = gpa;
    }

    public double getTotalAverage() {
        return totalAverage;
    }

    public void setTotalAverage(double totalAverage) {
        totalAverage = Math.round(totalAverage * 100.0) / 100.0;
        this.totalAverage = totalAverage;
    }
}


