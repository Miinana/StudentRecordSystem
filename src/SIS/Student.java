package SIS;

import java.util.ArrayList;

public class Student {
    private String name;
    private int id;
    private ArrayList<Course> courses;


    //Constructors
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.courses = new ArrayList<>();
    }

    //Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    // method for enrollment add courses to list (Connect student and course)
    public void enrollCourse(Course course) {
        courses.add(course);
    }

    // calculating GPA
    public double gpa() {
        double totalPoints = 0;
        double totalCreditHours = 0;

        for (Course course : courses) {
            for (Transcript transcript : course.studentTranscripts(this)) {
                totalPoints += (transcript.getPoints() * transcript.getTotalCreditHours());
                totalCreditHours += transcript.getTotalCreditHours();
            }
        }
        if (totalCreditHours == 0) {
            return 0.0;
        }
        double gpa = totalPoints / totalCreditHours;
        return Math.round(gpa * 100.0) / 100.0;
    }
    // Course drop method
    public String drop (Course course) {
        if (courses.contains(course)) {
            courses.remove(course);

            // Recalculate GPA
           System.out.println("After dropping a course: " );
            double newGPA = gpa();
            return "Course dropped: " + course.getCourseName() + "\nUpdated GPA: " + newGPA;
        } else {
            // course was not found in the schedule
            return "Course not found in the schedule.";
        }
    }

    public String toString() {
        String result = "| Transcript for " + name + " (ID " + id + ")" +
                "\n" + "-------------------------------------------------------------------" + "\n" +
                "|   Course name    |   Course Code   | Level | Credit Hours | Grade |\n" +
                "-------------------------------------------------------------------\n";

        for (Course course : courses) {
            for (Transcript transcript : course.studentTranscripts(this))  {
                result += String.format("| %-16s | %-15s | %-5s | %-12s | %-5s |\n",
                        course.getCourseName(), transcript.getCcd(), transcript.getLevel(),
                        transcript.getTotalCreditHours(), transcript.getGrade());
            }
        }
        result += "-------------------------------------------------------------------\n";
        result += "| GPA: " + gpa() + " |\n";
        result += "--------------\n";
        return result;
    }
}