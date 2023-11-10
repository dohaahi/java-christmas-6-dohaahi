package christmas.validator;

public enum ErrorMessage {
    ENTER_VALUE_MASSAGE("값을 입력해주세요."),
    INVALID_INPUT_NUMBER_MESSAGE("숫자를 입력해주세요."),
    INVALID_INPUT_ORDER_MENU_MESSAGE("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INVALID_INPUT_DATE_MESSAGE("유효하지 않은 날짜입니다. 다시 입력해 주세요.");

    private final String errorFormat = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return errorFormat + message;
    }
}
