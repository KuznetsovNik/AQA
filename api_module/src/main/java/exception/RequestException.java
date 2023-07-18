package exception;

/**
 * Исключение для HTTP-запросов
 */
public class RequestException extends RuntimeException {

    /**
     * @param message это текст исключения
     */
    public RequestException(String message) {
        super(message);
    }
}