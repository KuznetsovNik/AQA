package common.utils;

import java.security.SecureRandom;

public class RandomStringUtils {

    private static final SecureRandom RANDOM = new SecureRandom();
    private static final String latinCharacters = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRSsTtUuVvWwXxYyZz";

    public static String randomLatin(int count) {
        String name = "";
        for (int i = 0; i < count; i++) {
            char c = latinCharacters.charAt(RANDOM.nextInt(latinCharacters.length()));
            name += c;
        }
        return name;
    }
}