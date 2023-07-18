package model;

/**
 * Локализация + телефонный код страны
 */

public enum Location {
    BY("375"),
    RU("7");

    private final String code;

    Location(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}