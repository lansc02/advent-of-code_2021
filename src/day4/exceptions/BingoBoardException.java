package day4.exceptions;

public class BingoBoardException extends Exception{
    public BingoBoardException() {
    }

    public BingoBoardException(String message) {
        super(message);
    }

    public BingoBoardException(String message, Throwable cause) {
        super(message, cause);
    }

    public BingoBoardException(Throwable cause) {
        super(cause);
    }

    public BingoBoardException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
