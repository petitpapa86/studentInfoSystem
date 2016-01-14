package sis.tests;

import org.junit.Test;
import sis.report.Report;
import sis.report.RosterReport;
import sis.studentinfo.Session;
import sis.studentinfo.Student;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by petitpapa
 * on 12/01/16.
 */
public class RosterReportTest {
    @Test
    public void testRosterReport() {
        LocalDate date = LocalDate.of(2016, 1, 6);
        Session session = Session.courseSession("AB", "11", date);
        session.enroll(new Student("A"));
        session.enroll(new Student("B"));
        Report r = new RosterReport(session);
        assertThat(r.getReport(), is("----- Students -----" + "\n" +
                "A" + "\n" +
                "B" + "\n" +
                "----------------------" + "\n" +
                "Total student = " + 2));
    }
}
