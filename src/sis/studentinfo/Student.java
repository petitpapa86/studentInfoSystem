package sis.studentinfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by petitpapa
 * on 12/01/16.
 */
public class Student {
    public static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
    public static final String IN_STATE = "CO";
    private final String name;
    private GradingStrategy gradingStrategy;
    private int credit;
    private String inState;
    private List<Grade> grades = new ArrayList<>();

    public Student(String name) {
        this.name = name;
        gradingStrategy = new RegularGradingStudent();
    }

    public String getName() {
        return name;
    }

    public boolean isFullTime() {
        return getCredits() >= CREDITS_REQUIRED_FOR_FULL_TIME;
    }

    public int getCredits() {
        return credit;
    }

    public void addCredits(int value) {
        credit += value;
    }

    public boolean isInState() {
        return inState.equals("CO");
    }

    public void setInState(String inState) {
        this.inState = inState;
    }

    public double getGrade() {
        double total = 0;
        for (Grade e : grades) {
            total += getPointsFor(e);

        }
        return total;
    }

    private double getPointsFor(Grade grade) {
        return gradingStrategy.getGradePointsFor(grade);
    }

    public void addGrade(Grade grade) {
        if (!grades.contains(grade))
            grades.add(grade);
    }

    public double getGpa() {
        if (!grades.isEmpty())
            return getGrade() / grades.size();
        else return 0;
    }

    public void setGradingStrategy(GradingStrategy gradingStrategy) {
        this.gradingStrategy = gradingStrategy;
    }

    public enum Grade {
        A(4.0), B(3.0), C(2.0), D(1.0), F(0.0);
        private double value;

        Grade(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }
    }
}
