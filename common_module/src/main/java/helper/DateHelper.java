package helper;

import model.DateFormat;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Помощник работы с датами
 */

public class DateHelper {
    private static final LocalDate TODAY = LocalDate.now();

    public static String dateToString(Date date, DateFormat dateFormat) {
        return new SimpleDateFormat(dateFormat.getFormat()).format(date);
    }

    public static Date setDate(int day, int month, int year) {
        --month;
        Calendar calendar = new GregorianCalendar(year, month, day);
        return calendar.getTime();
    }

    public static int getActualYear() {
        return TODAY.getYear();
    }
}
