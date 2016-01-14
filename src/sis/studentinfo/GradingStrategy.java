package sis.studentinfo;

/**
 * Created by petitpapa
 * on 13/01/16.
 */
public interface GradingStrategy {
    double getGradePointsFor(Student.Grade grade);
}
