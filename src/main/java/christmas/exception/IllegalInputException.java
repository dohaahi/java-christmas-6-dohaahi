package christmas.exception;

public class IllegalInputException extends IllegalArgumentException {
    public static final String ERROR_FORMAT = "[ERROR] ";
    private static final String EXCEPTION_MESSAGE = "유효하지 않은 입력입니다. 다시 입력해 주세요.";

    public IllegalInputException() {
        super(ERROR_FORMAT + EXCEPTION_MESSAGE);
    }
}