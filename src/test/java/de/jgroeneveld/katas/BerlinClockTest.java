package de.jgroeneveld.katas;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/*
http://technologyconversations.com/2014/02/25/java-8-tutorial-through-katas-berlin-clock-easy/
 */
public class BerlinClockTest {
    BerlinClock berlinClock = new BerlinClock();

    @Test
    public void testYellowLampBlinksEveryTwoSeconds() throws Exception {
        berlinClock.setSeconds(0);
        assertThat(berlinClock.getSecondsRow(), equalTo("Y"));

        berlinClock.setSeconds(1);
        assertThat(berlinClock.getSecondsRow(), equalTo("O"));

        berlinClock.setSeconds(59);
        assertThat(berlinClock.getSecondsRow(), equalTo("O"));
    }

    @Test
    public void testTopHoursLightForEveryFiveHours() throws Exception {
        berlinClock.setHours(0);
        assertThat(berlinClock.getTopHoursRow(), equalTo("OOOO"));

        berlinClock.setHours(4);
        assertThat(berlinClock.getTopHoursRow(), equalTo("OOOO"));

        berlinClock.setHours(5);
        assertThat(berlinClock.getTopHoursRow(), equalTo("ROOO"));

        berlinClock.setHours(12);
        assertThat(berlinClock.getTopHoursRow(), equalTo("RROO"));

        berlinClock.setHours(18);
        assertThat(berlinClock.getTopHoursRow(), equalTo("RRRO"));

        berlinClock.setHours(24);
        assertThat(berlinClock.getTopHoursRow(), equalTo("RRRR"));
    }

    @Test
    public void testBottomHoursLightForEveryHourLeft() throws Exception {
        berlinClock.setHours(0);
        assertThat(berlinClock.getBottomHoursRow(), equalTo("OOOO"));

        berlinClock.setHours(4);
        assertThat(berlinClock.getBottomHoursRow(), equalTo("RRRR"));

        berlinClock.setHours(5);
        assertThat(berlinClock.getBottomHoursRow(), equalTo("OOOO"));

        berlinClock.setHours(12);
        assertThat(berlinClock.getBottomHoursRow(), equalTo("RROO"));

        berlinClock.setHours(18);
        assertThat(berlinClock.getBottomHoursRow(), equalTo("RRRO"));

        berlinClock.setHours(24);
        assertThat(berlinClock.getBottomHoursRow(), equalTo("RRRR"));
    }

    @Test
    public void testTopMinutesRowLightsFor5MinutesAndQuarters() throws Exception {
        berlinClock.setMinutes(0);
        assertThat(berlinClock.getTopMinutesRow(), equalTo("OOOOOOOOOOO"));

        berlinClock.setMinutes(11);
        assertThat(berlinClock.getTopMinutesRow(), equalTo("YYOOOOOOOOO"));

        berlinClock.setMinutes(16);
        assertThat(berlinClock.getTopMinutesRow(), equalTo("YYROOOOOOOO"));

        berlinClock.setMinutes(59);
        assertThat(berlinClock.getTopMinutesRow(), equalTo("YYRYYRYYRYY"));
    }

    @Test
    public void testBottomMinutesRowLightsForEveryMinuteLeft() throws Exception {
        berlinClock.setMinutes(0);
        assertThat(berlinClock.getBottomMinutesRow(), equalTo("OOOO"));

        berlinClock.setMinutes(11);
        assertThat(berlinClock.getBottomMinutesRow(), equalTo("YOOO"));

        berlinClock.setMinutes(16);
        assertThat(berlinClock.getBottomMinutesRow(), equalTo("YOOO"));

        berlinClock.setMinutes(59);
        assertThat(berlinClock.getBottomMinutesRow(), equalTo("YYYY"));
    }

    @Test
    public void testSetTime() throws Exception {
        berlinClock.setTime("12:42:17");
        assertThat(berlinClock.getHours(), equalTo(12));
        assertThat(berlinClock.getMinutes(), equalTo(42));
        assertThat(berlinClock.getSeconds(), equalTo(17));
    }

    @Test
    public void testCompleteDisplay() throws Exception {
        berlinClock.setTime("00:00:00");
        assertThat(berlinClock.display(), equalTo("" +
                        "Y\n" +
                        "OOOO\n" +
                        "OOOO\n" +
                        "OOOOOOOOOOO\n" +
                        "OOOO"
        ));

        berlinClock.setTime("16:37:16");
        assertThat(berlinClock.display(), equalTo("" +
                        "Y\n" +
                        "RRRO\n" +
                        "ROOO\n" +
                        "YYRYYRYOOOO\n" +
                        "YYOO"
        ));
    }
}