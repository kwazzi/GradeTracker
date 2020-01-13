package sample;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;



public class Course {
    private String courseName;
    private double courseGrade;
    private double courseWeight;
    private double courseX;
    private double courseY;

    public Course(){

    }

    public Course(String name, double grade, double weight){
        this.courseGrade = grade;
        this.courseName = name;
        this.courseWeight = weight;
    }

    public TextArea drawCourse(){
        TextArea textArea = new TextArea();
        textArea.setText(courseName + ": " + courseGrade + " " + courseWeight);
        //textArea.setLayoutX(courseX);
        //textArea.setLayoutY(courseY);
        textArea.setMinSize(250, 20);
        textArea.setMaxSize(250, 20);

        return textArea;

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

    public double getCourseX() {
        return courseX;
    }

    public double getCourseY() {
        return courseY;
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

    public void setCourseX(double courseX) {
        this.courseX = courseX;
    }

    public void setCourseY(double courseY) {
        this.courseY = courseY;
    }
}

