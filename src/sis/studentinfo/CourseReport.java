package sis.studentinfo;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static sis.report.ReportUtilities.NEW_LINE;

/**
 * Created by petitpapa
 * on 13/01/16.
 */
public class CourseReport {
    private List<Session> sessions = new ArrayList<>();
    private String result = "";

    public void add(Session session) {
        if (session != null)
            sessions.add(session);
        Collections.sort(sessions);
    }

    public String getText() {

        for (Session s : sessions) {
            add(s.getDepartment());
            add(" ");
            add(s.getNumber());
            add(NEW_LINE);
        }
        return result;
    }

    private void add(String text) {
        result += text;
    }
}
