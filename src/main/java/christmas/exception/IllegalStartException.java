package christmas.exception;

import static christmas.exception.IllegalInputException.ERROR_FORMAT;

public class IllegalStartException extends IllegalStateException {
    private static final String EXCEPTION_MESSAGE = "예상치 못한 오류가 발생하였습니다. 게임을 재실행하겠습니다.";

    public IllegalStartException() {
        super(ERROR_FORMAT + EXCEPTION_MESSAGE);
    }
}