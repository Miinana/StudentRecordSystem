package SIS;

import java.util.ArrayList;

public class Course {
    private final String courseName;
    private ArrayList<Transcript> transcripts;

    //Constructors
    public Course(String courseName) {
        this.courseName = courseName;
        this.transcripts = new ArrayList<>(); // Create array List for transcripts
    }

    public String getCourseName() {
        return courseName;
    }

    public ArrayList<Transcript> getTranscripts() {
        return transcripts;
    }

    public void addTranscripts(Transcript transcript, Student student) {
        transcripts.add(transcript);
    }

    // Create an array transcript for the student
    public ArrayList<Transcript> studentTranscripts(Student student) {
        ArrayList<Transcript> studentTranscripts = new ArrayList<>();

        for (Transcript transcript : transcripts) {
            if (transcript.getStudent().equals(student)) {
                studentTranscripts.add(transcript);
            }
        }
        return studentTranscripts;
    }
}

