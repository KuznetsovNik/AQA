package model;

/**
 * Типы документов и их код
 */

public enum DocType {
    PASSPORT_RU("100"),
    RESIDENT_CARD_RU("200"),
    PASSPORT_BY("300"),
    RESIDENT_CARD_BY("400"),
    ANOTHER_DOC("500");

    private final String code;

    DocType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
