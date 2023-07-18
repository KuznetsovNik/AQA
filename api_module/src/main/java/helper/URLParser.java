package helper;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

public final class URLParser {
    public static Map<String, String> splitQuery(String url) {
        Map<String, String> queryPairs = new LinkedHashMap<>();
        String[] pairs = url.split("[&?]");
        for (int i = 1; i < pairs.length; i++) {
            int idx = pairs[i].indexOf("=");
            queryPairs.put(URLDecoder.decode(pairs[i].substring(0, idx), StandardCharsets.UTF_8),
                    URLDecoder.decode(pairs[i].substring(idx + 1), StandardCharsets.UTF_8));

        }

        return queryPairs;
    }
}