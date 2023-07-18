package common.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DatesUtils {
    private static DateTimeFormatter formats = DateTimeFormatter.ofPattern("dd.MM.YYYY");

    private DatesUtils() {
    }

    public static String getCurrentDate() {
        LocalDate date = LocalDate.now();

        return date.format(formats);
    }

    public String customDate(int year, int month, int day) {
        LocalDate date = LocalDate.of(year, month, day);
        return date.format(formats);
    }

    public String tommorow() {
        LocalDate date = LocalDate.now().plusDays(1);

        return date.format(formats);
    }

    public String pastDate(int randInt) {
        LocalDate date = LocalDate.now()
                .minusYears(randInt)
                .minusMonths(randInt)
                .minusDays(randInt);

        return date.format(formats);
    }
}