package sis.studentinfo;

import static sis.studentinfo.Student.Grade;

/**
 * Created by petitpapa
 * on 13/01/16.
 */
public class HonorsGradingStrategy implements GradingStrategy {
    @Override
    public double getGradePointsFor(Grade grade) {
        if (grade != Grade.F)
            return grade.getValue() + 1;
        else return grade.getValue();
    }
}
