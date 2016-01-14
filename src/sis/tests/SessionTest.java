package sis.tests;

import org.junit.Before;
import org.junit.Test;
import sis.studentinfo.Session;
import sis.studentinfo.Student;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Created by petitpapa
 * on 12/01/16.
 */
public class SessionTest {
    private static final int CREDITS = 3;

    private Session session;

    @Before
    public void init() {
        session = createCourseSession();
    }


    @Test
    public void testCreate() {

        assertThat(session.getDepartment(), is("ENGL"));
        assertThat(session.getNumber(), is("101"));
    }

    @Test
    public void testEnrollStudents() {

        Student student1 = new Student("Cisse");
        session.enroll(student1);
        assertThat(student1.getCredits(), is(CREDITS));
        assertThat(session.getNumberOfStudent(), is(1));

        Student student2 = new Student("Thelma");
        session.enroll(student2);
        assertThat(session.getNumberOfStudent(), is(2));

        assertThat(session.getStudentName(student1), is("Cisse"));

    }

    @Test
    public void testThrowExceptionWhenNull() {
        try {
            session.enroll(null);
            fail();
        } catch (NullPointerException e) {
            assertThat(e.getMessage(), containsString("Student should not be null"));
        }
    }

    @Test
    public void testCourseDate() {
        LocalDate startDate = LocalDate.of(2016, 1, 6);
        Session session = Session.courseSession("ENGL", "101", startDate);
        assertThat(session.getEndDate(), is(LocalDate.of(2016, 4, 24)));
        assertThat(session.getStartDate(), is(LocalDate.of(2016, 1, 6)));
    }


    private Session createCourseSession() {
        Session session = Session.courseSession("ENGL", "101", LocalDate.of(2016, 1, 6));
        session.setNumberOfCredits(SessionTest.CREDITS);
        return session;
    }
}
