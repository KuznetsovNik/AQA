package constant;

import static constant.Day.getDatePlusOneYear;
import static constant.Day.getTodayDate;

public class DataMoneyTransfer {
    public static final long SENDER_CARD_NUMBER_V = 192929393848l;
    public static final int TRANSFER_TYPE_V = 2;
    public static final String TRANSFER_SUM = "100.00";
    public static final String RUB_CURRENCY = "RUB";
    public static final int PAYEE_ACCOUNT_NUMBER = 5000500;
    public static final String COMMISSION = "0.50";
    public static final String PURPOSE = "Возврат долга";
    public static final int TRANSFER_SYSTEM = 1;
    public static final String CURRENCY_EXCHANGE = "1.00";
    public static final int AUTHORIZATION_CODE = 123;
    public static final String EXCH_SUM = "11.0";
    public static final String EXCH_RATE = "12.0";
    public static final String MOBILE_PHONE_V = "+79113456678";

    public static final int PERIODICITY = 800;
    public static final String START_DATE = getTodayDate();
    public static final String EXPIRATION_DATE = getDatePlusOneYear();
}