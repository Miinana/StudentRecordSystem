package SIS;

public class StudentRecordSystem {
    public static void main(String[] arg) {

        // Create courses
        Course math = new Course("Math");
        Course computerScience = new Course("Computer Science");
        Course English = new Course("English");
        Course history = new Course("History");

        // Create students
        Student Mina = new Student("Maryam", 1);
        Student Ariya = new Student("Ariya", 2);

        //add courses to each student
        Mina.enrollCourse(math);
        Mina.enrollCourse(English);
        Mina.enrollCourse(history);
        
        Ariya.enrollCourse(math);
        Ariya.enrollCourse(computerScience);
        Ariya.enrollCourse(history);

        // Create transcript for each student
        Transcript transcript1 = new Transcript(Mina, "A", "MATH101","Bs", 3 );
        Transcript transcript2 = new Transcript(Mina, "B", "ENGLISH101","Bs", 3 );
        Transcript transcript3 = new Transcript(Mina, "B", "HIST201","Bs", 3 );
        Transcript transcript4 = new Transcript(Ariya, "C", "MATH101","Bs", 3);
        Transcript transcript5 = new Transcript(Ariya, "B", "CS201","Bs", 4);
        Transcript transcript6 = new Transcript(Ariya, "A", "HIST201","Bs", 3);

        // match course and transcript (I add student as argument for better understanding)
        math.addTranscripts(transcript1, Mina);
        English.addTranscripts(transcript2, Mina);
        history.addTranscripts(transcript3, Mina);

        math.addTranscripts(transcript4, Ariya);
        computerScience.addTranscripts(transcript5, Ariya);
        history.addTranscripts(transcript6, Ariya);

        System.out.println(Mina.toString());
        System.out.println(Ariya.toString());

        Ariya.drop(math);
        Ariya.enrollCourse(math);
        System.out.println(Ariya.toString());
    }
}