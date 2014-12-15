package de.jgroeneveld.katas;

/**
 * Created by jgroeneveld on 15.12.14.
 */
public class BerlinClock {
    private int seconds;
    private int hours;
    private int minutes;

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    // sets the time in the format hh:mm:ss
    public void setTime(String time) {
        String[] data = time.split(":");

        setHours(Integer.parseInt(data[0]));
        setMinutes(Integer.parseInt(data[1]));
        setSeconds(Integer.parseInt(data[2]));
    }

    public String getSecondsRow() {
        if (seconds % 2 == 0) {
            return "Y";
        } else {
            return "O";
        }
    }

    public String getTopHoursRow() {
        int onLights = hours / 5;
        return buildHoursRow(onLights, "R");
    }

    public String getBottomHoursRow() {
        int onLights = hours % 5;
        return buildHoursRow(onLights, "R");
    }

    public String getTopMinutesRow() {
        String alphabet = "YYR";
        int pointer = 0;
        int minutesLeft = minutes;
        String result = "";

        do {
            minutesLeft -= 5;
            if (minutesLeft > 0) {
                result += alphabet.charAt(pointer);
                pointer = (pointer + 1) % alphabet.length();
            }
        } while (minutesLeft > 0);

        result = fillRowWithOffLights(result, 11);

        return result;
    }

    private String buildHoursRow(int onLights, String indicator) {


        String result = "";
        for (int i = 0; i < onLights; i++) {
            result += indicator;
        }

        result = fillRowWithOffLights(result, 4);

        return result;
    }

    private String fillRowWithOffLights(String row, int rowLength) {
        int offLights = rowLength - row.length();
        for (int i = 0; i < offLights; i++) {
            row += "O";
        }
        return row;
    }

    public String getBottomMinutesRow() {
        int onLights = minutes % 5;
        return buildHoursRow(onLights, "Y");
    }

    public String display() {
        return getSecondsRow() + "\n" + getTopHoursRow() + "\n" + getBottomHoursRow() + "\n" + getTopMinutesRow() + "\n" + getBottomMinutesRow();
    }
}
