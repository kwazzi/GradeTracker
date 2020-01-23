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
    private static int courseIndex = 0;

    public Course(){
        courseIndex ++;
        System.out.println(courseIndex);
    }

    public Course(String name, double grade, double weight){
        courseIndex++;
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

    public static int getCourseIndex() {
        return courseIndex;
    }

    public static void setCourseIndex(int courseIndex) {
        Course.courseIndex = courseIndex;
    }

    @Override
    public String toString(){
        return capitalizeString(courseName) + "  " + courseGrade + "  " + courseWeight;
    }

    public static String capitalizeString(String string) {
        char[] chars = string.toLowerCase().toCharArray();
        boolean found = false;
        for (int i = 0; i < chars.length; i++) {
            if (!found && Character.isLetter(chars[i])) {
                chars[i] = Character.toUpperCase(chars[i]);
                found = true;
            } else if (Character.isWhitespace(chars[i]) || chars[i]=='.' || chars[i]=='\'') { // You can add other chars here
                found = false;
            }
        }
        return String.valueOf(chars);
    }

}
