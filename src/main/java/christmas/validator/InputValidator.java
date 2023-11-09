package christmas.validator;

import java.util.regex.Pattern;

public class InputValidator {
    public static final String NUMBER_REGEX = "^[\\d]*$";
    public static final String MENU_ORDER_REGEX = "^[ㄱ-ㅎ|가-힣]+-[\\d]*$";

    public static void validateValueEmpty(final String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.ENTER_VALUE_MASSAGE.getMessage());
        }
    }

    public static void validateDateMatchedNumberRegex(final String input) {
        if (!Pattern.matches(NUMBER_REGEX, input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_NUMBER_MESSAGE.getMessage());
        }
    }

    public static void validateMenuOrderMatchedMenuOrderRegex(final String input) {
        if (!Pattern.matches(MENU_ORDER_REGEX, input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_ORDER_MENU_MESSAGE.getMessage());
        }
    }
}
