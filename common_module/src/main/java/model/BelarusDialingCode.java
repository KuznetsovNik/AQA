package model;

/**
 * Коды мобильных операторов РБ
 */

public enum BelarusDialingCode {
    CODE_29("29"),
    CODE_44("44"),
    CODE_25("25"),
    CODE_33("33");

    private final String code;

    BelarusDialingCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
