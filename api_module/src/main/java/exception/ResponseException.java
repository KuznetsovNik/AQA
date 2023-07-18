package exception;

/**
 * Исключение для HTTP-ответов
 */
public class ResponseException extends RuntimeException {

    /**
     * @param message это текст исключения
     */
    public ResponseException(String message) {
        super(message);
    }
}