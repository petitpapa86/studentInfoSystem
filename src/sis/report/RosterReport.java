package sis.report;

import sis.studentinfo.Session;
import sis.studentinfo.Student;

import java.util.List;

/**
 * Created by petitpapa
 * on 12/01/16.
 */
public class RosterReport implements Report {


    private static Session session;


    public RosterReport(Session session) {
        RosterReport.session = session;
    }


    public String getReport() {
        StringBuilder result = new StringBuilder();
        result.append(ReportUtilities.header());
        List<Student> students = session.getStudents();
        for (Student e : students)
            result.append(e.getName()).append(ReportUtilities.NEW_LINE);
        result.append(ReportUtilities.footer()).append(session.getNumberOfStudent());
        return result.toString();
    }

}
