package day4.exceptions;

import day4.exceptions.BingoBoardException;

public class OutofBoundsException extends BingoBoardException {
    public OutofBoundsException() {
    }

    public OutofBoundsException(String message) {
        super(message);
    }

    public OutofBoundsException(String message, Throwable cause) {
        super(message, cause);
    }

    public OutofBoundsException(Throwable cause) {
        super(cause);
    }

    public OutofBoundsException(String message, Throwable cause, boolean enableSuppression,
                                boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
