package christmas.exception;

import static christmas.exception.IllegalInputException.ERROR_FORMAT;

public class IllegalDateException extends IllegalArgumentException {
    private static final String EXCEPTION_MESSAGE = "유효하지 않은 날짜입니다. 다시 입력해 주세요.";

    public IllegalDateException() {
        super(ERROR_FORMAT + EXCEPTION_MESSAGE);
    }
}