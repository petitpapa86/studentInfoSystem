package sis.tests;

import org.junit.Test;
import sis.studentinfo.Session;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by petitpapa
 * on 13/01/16.
 */
public class SummerSessionTest {
    @Test
    public void testEndDate() {
        Session session =
                Session.summerSession("NGL", "200", LocalDate.of(2016, 6, 9));
        assertThat(session.getEndDate(), is(LocalDate.of(2016, 8, 1)));
    }
}
