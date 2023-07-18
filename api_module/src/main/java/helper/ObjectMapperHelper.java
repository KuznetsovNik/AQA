package helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.response.JsonResponse;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;

import static java.util.stream.Collectors.joining;

/**
 * Маппинг и конвертирование разных объектов
 *
 * @see ObjectMapper
 */
public final class ObjectMapperHelper {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * @param obj объект (скорее всего тело запроса), который необходимо конвертировать в x-www-form-urlencoded
     * @return возвращает то же тело, только в виде строки формата x-www-form-urlencoded
     */
    public static String convertToUrlEncoded(Object obj) {
        Map<String, String> params = MAPPER.convertValue(obj, Map.class);

        return params.keySet().stream().map(key -> {
                    String value = params.get(key);
                    try {
                        return value != null && value.length() > 0
                                ? key + "=" + URLEncoder.encode(value, StandardCharsets.UTF_8.toString())
                                : null;
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }

                    return null;
                })
                .filter(Objects::nonNull)
                .collect(joining("&"));
    }

    /**
     * @param response ответ HTTP-запроса
     * @param clazz    - класс, в который необходимо смаппить данные. Передаем сюда, например: Test.class
     * @param <T>      - дженерик для работы с классами разных типов
     * @return возвращает объект того класса, который передали в аргументе метода
     */
    public static <T> T mapJsonToObject(JsonResponse response, Class<T> clazz) {
        String json = response.getJsonObject().toString();
        try {
            return MAPPER.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return (T) json;
    }
}