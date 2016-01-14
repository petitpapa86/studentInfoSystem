package sis.tests;

import org.junit.Test;
import sis.studentinfo.CourseReport;
import sis.studentinfo.Session;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static sis.report.ReportUtilities.NEW_LINE;

/**
 * Created by petitpapa
 * on 13/01/16.
 */
public class CourseReportTest {
    @Test
    public void testReport() {
        CourseReport report = new CourseReport();
        report.add(Session.courseSession("ENGL", "101", LocalDate.now()));
        report.add(Session.courseSession("ITAL", "410", LocalDate.now()));
        report.add(Session.courseSession("CZEC", "200", LocalDate.now()));
        report.add(Session.courseSession("CZEC", "202", LocalDate.now()));

        assertThat(report.getText(), is("CZEC 200" + NEW_LINE +
                "CZEC 202" + NEW_LINE +
                "ENGL 101" + NEW_LINE +
                "ITAL 410" + NEW_LINE
        ));
    }
}
