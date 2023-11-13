package christmas.exception;

import static christmas.exception.IllegalInputException.ERROR_FORMAT;

public class IllegalMenuException extends IllegalArgumentException {
    private static final String EXCEPTION_MESSAGE = "유효하지 않은 주문입니다. 다시 입력해 주세요.";

    public IllegalMenuException() {
        super(ERROR_FORMAT + EXCEPTION_MESSAGE);
    }
}
