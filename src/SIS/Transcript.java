package SIS;

public class Transcript {
    private Student student;
    private String grade;
    private String ccd; //course code number
    private String level;
    private double totalCreditHours;
    private double points;
    private Course course;

    //Constructors
    public Transcript(Student student, String grade, String ccd, String level, double totalCreditHours) {
        this.student = student;
        this.grade = grade;
        this.ccd = ccd;
        this.level = level;
        this.totalCreditHours = totalCreditHours;
    }

    public Student getStudent() {
        return student;
    }

    public String getCcd() {
        return ccd;
    }

    public void setCcd(String ccd) {
        this.ccd = ccd;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public double getTotalCreditHours() {
        return totalCreditHours;
    }

    public void setTotalCreditHours(double totalCreditHours) {
        this.totalCreditHours = totalCreditHours;
    }

    public double getPoints() {
        return calculatePoint();
    }

    public void setPoints(double points) {
        this.points = points;
    }
    // convert grads to numbers
    public double calculatePoint() {
        return switch (grade) {
            case "A" -> 4.0;
            case "B" -> 3.0;
            case "C" -> 2.0;
            case "D" -> 1.0;
            default -> 0.0;
        };
    }
}