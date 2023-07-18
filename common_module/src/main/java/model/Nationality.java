package model;

/**
 * Гражданство
 */

public enum Nationality {
    RUSSIA("Russia"),
    BELARUS("Belarus");

    private final String nationality;

    Nationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNationality() {
        return nationality;
    }
}
