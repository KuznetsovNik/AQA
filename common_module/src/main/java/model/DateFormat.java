package model;

/**
 * Форматы даты
 */

public enum DateFormat {
    yyyy_MM_dd("yyyy-MM-dd"),
    dd_MM_yyyy("dd-MM-yyyy");

    private final String format;

    DateFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
