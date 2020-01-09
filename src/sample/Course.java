package sample;

import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class Course {
    private String courseName;
    private double courseGrade;
    private double courseWeight;

    public Course(){

    }

    public HBox drawCourse(){
        HBox box = new HBox();
        box.setSpacing(10);

        Text name = new Text(courseName);
        Text grade = new Text(Double.toString(courseGrade));
        Text weight = new Text(Double.toString(courseWeight));

        box.getChildren().addAll(name, grade, weight);

        return null;
    }

    public double getCourseWeight() {
        return courseWeight;
    }

    public double getCourseGrade() {
        return courseGrade;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseWeight(double courseWeight) {
        this.courseWeight = courseWeight;
    }

    public void setCourseGrade(double courseGrade) {
        this.courseGrade = courseGrade;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
