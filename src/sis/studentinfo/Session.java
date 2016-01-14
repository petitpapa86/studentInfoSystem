package sis.studentinfo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by petitpapa
 * on 12/01/16.
 */
public class Session implements Comparable<Session> {

    public static final int dayInWeek = 7;
    public static final int daysFromFridayToMonday = 3;
    protected final LocalDate startDate;
    private final String department;
    private final String number;
    private final List<Student> students = new ArrayList<>();
    protected String courseSession;
    private int sessionLength;
    private int numberOfCredits;


    public Session(String department, String number, LocalDate startDate, String courseSession, int sessionLength) {
        this.startDate = startDate;
        this.department = department;
        this.number = number;
        this.courseSession = courseSession;
        this.sessionLength = sessionLength;
    }

    public static Session courseSession(String department, String number,
                                        LocalDate startDate) {
        return new Session(department, number, startDate, "courseSession", 16);
    }

    public static Session summerSession(String department, String number,
                                        LocalDate startDate) {
        return new Session(department, number, startDate, "Summer Session", 8);
    }

    public String getDepartment() {
        return department;
    }

    public String getNumber() {
        return number;
    }

    public void enroll(Student student) {
        if (student == null)
            throw new NullPointerException("Student should not be null");
        if (!students.contains(student)) {
            students.add(student);
            student.addCredits(numberOfCredits);
        }
    }

    public int getNumberOfStudent() {
        return students.size();
    }

    public String getStudentName(Student student) {
        return students.stream().filter(e -> e.getName().equals(student.getName())).
                map(Student::getName).findFirst().orElse("");
    }

    public LocalDate getEndDate() {
        return startDate.plusDays(getSessionLength() * dayInWeek - daysFromFridayToMonday);
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    @Override
    public int compareTo(Session other) {
        int compare = department.compareTo(other.getDepartment());
        if (compare == 0)
            compare = number.compareTo(other.getNumber());
        return compare;
    }

    public int getSessionLength() {
        return sessionLength;
    }
}
