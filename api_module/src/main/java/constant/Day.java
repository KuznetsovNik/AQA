package constant;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Day {

    private static LocalDate today = LocalDate.now();
    private static String pattern = "yyyy-MM-dd";
    private static String timeZone = "T00:00:00Z";


    public static String getDatePlusOneYear() {
        return (today.plusYears(1)).format(DateTimeFormatter.ofPattern(pattern)) + timeZone;
    }

    public static String getTodayDate() {
        return today.format(DateTimeFormatter.ofPattern(pattern)) + timeZone;
    }
}