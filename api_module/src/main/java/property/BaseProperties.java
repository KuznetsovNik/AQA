package property;

import static property.PropertiesReader.getIntValue;
import static property.PropertiesReader.getPropertyValue;

/**
 * Константы параметров, считанных из файла config.properties
 *
 * @see PropertiesReader
 */
public final class BaseProperties {

    public static String BASE_URL = getPropertyValue("base_url");
    public static String CODE = getPropertyValue("code");
    public static String CODE_PASSPORT = getPropertyValue("code_passport");
    public static String LOGIN = getPropertyValue("login");
    public static String PASSWORD = getPropertyValue("password");
    public static int SOCKET_TIMEOUT_CONNECTION = getIntValue("timeout.socket.connect");
    public static String LOGIN_PASSPORT = getPropertyValue("login.passport");

    public static String DB_HOST = getPropertyValue("dbHost");
    public static String DB_PORT = getPropertyValue("dbPort");
    public static String DB_NAME = getPropertyValue("dbName");
    public static String DB_USER = getPropertyValue("dbUser");
    public static String DB_PASS = getPropertyValue("dbPass");
    public static String DB_USER_SERVICE_NAME = getPropertyValue("dbUserServiceName");
    public static String DB_INFO_SERVICE_NAME = getPropertyValue("infoServiceDev");
    public static String DB_DEPOSIT_SERVICE_NAME = getPropertyValue("dbDepositServiceName");
    public static String DB_CREDIT_SERVICE_NAME = getPropertyValue("dbCreditServiceName");
    public static String DB_MT_NAME = "moneytransfer_dev";

    public static String LOGIN_PASSPORT_NOT_CORRECT = getPropertyValue("login.passport.not.correct");
    public static String PASSWORD_NOT_CORRECT = getPropertyValue("password.not.correct");
}