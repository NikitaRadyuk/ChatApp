package by.it.jd2.Mk_JD2_103_23.chatApp.core.exceptions;

/**
 * Класс исключения "Валидации"
 */
public class ValidationException extends RuntimeException{
    public ValidationException() {
    }

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidationException(Throwable cause) {
        super(cause);
    }

    public ValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
