package sis.studentinfo;

import static sis.studentinfo.Student.Grade;

/**
 * Created by petitpapa on
 * 13/01/16.
 */
public class RegularGradingStudent implements GradingStrategy {
    @Override
    public double getGradePointsFor(Grade grade) {
        return grade.getValue();
    }
}
