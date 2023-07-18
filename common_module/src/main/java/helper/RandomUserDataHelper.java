package helper;

import model.*;

import java.util.Locale;

import static manager.ResourceManager.*;

/**
 * Помощник генерации случайных данных пользователя
 */

public class RandomUserDataHelper extends RandomHelper {

    public static String generateRandomTelephoneNumber(Location location) {
        if (location.equals(Location.BY)) {
            int digitCountBY = 7;
            BelarusDialingCode code = getRandomEnumExemplar(BelarusDialingCode.values());
            return  String.format("%s%s", code.getCode(), randomNumeric(digitCountBY));
        } else {
            int digitCountRU = 10;
            return String.format("%s", randomNumeric(digitCountRU));
        }
    }

    public static String generateRandomDocumentNumber(DocType docType) {
        String documentNumber = null;
        switch (docType) {
            case PASSPORT_RU:
                documentNumber = String.format("%s%s", randomNumeric(4), randomNumeric(6));
                break;
            case RESIDENT_CARD_RU:
                documentNumber = String.format("%s", randomNumeric(9));
                break;
            case PASSPORT_BY:
            case RESIDENT_CARD_BY:
                documentNumber = String.format("%s%s", randomString(2).toUpperCase(Locale.ROOT), randomNumeric(7));
                break;
            case ANOTHER_DOC:
                documentNumber = String.format("%s", randomNumeric(15));
                break;
        }
        return documentNumber;
    }

    public static String generateRandomEmail() {
        return String.format("%s@maila.net", randomString(12));
    }

    public static String generateRandomIdentificationNumber() {
        return String.format("%s%s%s%s%s", randomNumeric(7), randomString(1).toUpperCase(Locale.ROOT)
                , randomNumeric(3), randomString(2).toUpperCase(Locale.ROOT), randomNumeric(1));
    }

    public static String getRandomFirstName() {
        return getRandomStringFromJsonArray(FIRSTNAMES);
    }

    public static String getRandomSurname() {
        return getRandomStringFromJsonArray(SURNAMES);
    }

    public static String getRandomPatronymic() {
        return String.format("%sovich", getRandomFirstName());
    }
}
