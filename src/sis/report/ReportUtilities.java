package sis.report;

/**
 * Created by petitpapa
 * on 12/01/16.
 */
public class ReportUtilities {

    public static String NEW_LINE = System.lineSeparator();

    public static String header() {
        return "----- Students -----" + NEW_LINE;
    }

    public static String footer() {
        return "----------------------" + NEW_LINE +
                "Total student = ";
    }
}
