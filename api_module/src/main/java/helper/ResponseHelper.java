package helper;

import exception.ResponseException;
import model.response.JsonResponse;
import org.apache.http.HttpStatus;

/**
 * Класс, содержащий методы для проверки кода ответа в сервисах
 */
public final class ResponseHelper {

    /**
     * Проверяет, что пришел ответ со статус-кодом 200
     *
     * @param response ответ HTTP-запроса
     */
    public static void assertOk(JsonResponse response) {
        assertCode(response, HttpStatus.SC_OK);
    }

    /**
     * Проверяет, что пришел ответ со статус-кодом 302
     *
     * @param response ответ HTTP-запроса
     */
    public static void assertMoved(JsonResponse response) {
        assertCode(response, HttpStatus.SC_MOVED_TEMPORARILY);
    }

    private static void assertCode(JsonResponse response, int expectedCode) {
        if (response.getStatusCode() != expectedCode) {
            throw new ResponseException(String.format("Request error. Expected response code: %d, actual: %d\nBody: %s",
                    expectedCode,
                    response.getStatusCode(),
                    response.getJsonObject() != null ? response.getJsonObject().toString() : "no body"));
        }
    }
}