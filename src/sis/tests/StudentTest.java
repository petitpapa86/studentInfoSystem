package sis.tests;

import org.junit.Test;
import sis.studentinfo.HonorsGradingStrategy;
import sis.studentinfo.Student;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by petitpapa
 * on 12/01/16.
 */
public class StudentTest {
    @Test
    public void testCreate() {
        Student janeDoe = new Student("Jane Doe");
        assertThat(janeDoe.getName(), is("Jane Doe"));
    }

    @Test
    public void testStudentStatus() {
        Student a = new Student("A");
        assertThat(a.getCredits(), is(0));
        a.addCredits(3);
        assertThat(a.isFullTime(), is(false));
        assertThat(a.getCredits(), is(3));
        a.addCredits(4);
        assertThat(a.getCredits(), is(7));
        assertThat(a.isFullTime(), is(false));
        a.addCredits(5);
        assertThat(a.getCredits(), is(12));
        assertThat(a.isFullTime(), is(true));


    }

    @Test
    public void testInState() {
        Student a = new Student("A");
        assertThat(a.isInState(), is(false));
        a.setInState(Student.IN_STATE);
        assertThat(a.isInState(), is(true));
    }

    @Test
    public void testCalculateGrade() {
        Student a = new Student("A");
        assertThat(a.getGrade(), is(0.0));
        a.addGrade(Student.Grade.A);
        assertThat(a.getGrade(), is(4.0));
        a.addGrade(Student.Grade.B);
        assertThat(a.getGrade(), is(7.0));
        a.addGrade(Student.Grade.C);
        assertThat(a.getGrade(), is(9.0));
        a.addGrade(Student.Grade.D);
        assertThat(a.getGrade(), is(10.0));
        assertThat(a.getGpa(), is(2.5));
    }

    @Test
    public void testCalculateHonorsStudentGpa() {
        Student a = createHonorsStudent();
        assertThat(a.getGpa(), is(0.0));
        a.addGrade(Student.Grade.A);
        assertThat(a.getGpa(), is(5.0));
    }

    private Student createHonorsStudent() {
        Student a = new Student("a");
        a.setGradingStrategy(new HonorsGradingStrategy());

        return a;
    }

}