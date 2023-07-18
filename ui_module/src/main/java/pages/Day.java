package pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Day {

    private static LocalDate today = LocalDate.now();
    private static String pattern = "dd.MM.yyyy";

    public static String getTomorrowDate() {
        return (today.plusDays(1)).format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String getEighteenYearsAgoDate() {
        return (today.minusYears(18)).format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String getSeventeenYearsAgoDate() {
        return (today.minusYears(18).plusDays(1)).format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String getTodayDate() {
        return today.format(DateTimeFormatter.ofPattern(pattern));
    }
}
