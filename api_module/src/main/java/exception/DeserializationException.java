package exception;

/**
 * Исключение для десериализации
 */
public class DeserializationException extends RuntimeException {
    /**
     * @param message это текст исключения
     */
    public DeserializationException(String message) {
        super(message);
    }
}