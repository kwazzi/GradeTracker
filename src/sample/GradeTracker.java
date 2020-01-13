package sample;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GradeTracker {
    ArrayList<Course> courses = new ArrayList<>();

    public GradeTracker(){

    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }
}
