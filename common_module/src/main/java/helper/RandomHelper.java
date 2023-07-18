package helper;

import model.DateFormat;
import org.json.JSONArray;

import java.util.Random;

/**
 * Помощник генерации случайных данных
 */

public class RandomHelper {
    private static final Random RANDOM = new Random();

    public static int randomInt(int min, int max) {
        max -= min;
        return RANDOM.nextInt(max) + min;
    }

    public static String randomNumeric(int digitCount) {
        int i = 0;
        --digitCount;
        StringBuilder randomNumeric = new StringBuilder();
        randomNumeric.append(randomInt(1, 9));
        while (i < digitCount) {
            randomNumeric.append(RANDOM.nextInt(9));
            i++;
        }
        return randomNumeric.toString();
    }

    public static String randomString(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(randomLatinChar());
        }
        return sb.toString();
    }

    public static String randomDate(int minYear, int maxYear, DateFormat dateFormat) {
        int randomYear = minYear == maxYear ? minYear : randomInt(minYear, maxYear);
        int randomMonth = randomInt(1, 12);
        int randomDay;
        int maxMonthDay;
        boolean isThirtyOneDaysHasMonth = randomMonth < 8 && randomMonth % 2 > 0 || randomMonth > 7 && randomMonth % 2 == 0;
        boolean firstHighYearCondition = randomYear % 4 == 0 && randomYear % 100 > 0;
        boolean secondHighYearCondition = randomYear % 100 == 0 && randomYear % 400 == 0;
        if (isThirtyOneDaysHasMonth) {
            maxMonthDay = 31;
        } else if (randomMonth == 2) {
            if (firstHighYearCondition || secondHighYearCondition) {
                maxMonthDay = 29;
            } else {
                maxMonthDay = 28;
            }
        } else {
            maxMonthDay = 30;
        }
        randomDay = randomInt(1, maxMonthDay);
        return DateHelper.dateToString(DateHelper.setDate(randomDay, randomMonth, randomYear), dateFormat);
    }

    public static <E extends Enum<E>> E getRandomEnumExemplar(E[] values) {
        return values[RANDOM.nextInt(values.length)];
    }

    public static String getRandomStringFromJsonArray(JSONArray jsonArray) {
        return jsonArray.get(RANDOM.nextInt(jsonArray.length())).toString();
    }

    public static Random getRandom() {
        return RANDOM;
    }

    private static char randomLatinChar() {
        int firstEnglishLetterUnicode = 'a';
        int lastEnglishLetterUnicode = 'z';
        return (char) (randomInt(firstEnglishLetterUnicode, lastEnglishLetterUnicode + 1));
    }
}
