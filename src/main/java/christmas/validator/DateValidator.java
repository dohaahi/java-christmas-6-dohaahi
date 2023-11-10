package christmas.validator;

import static christmas.domain.Date.MAX_DATE_IN_MONTH;
import static christmas.domain.Date.MIN_DATE_IN_MONTH;
import static christmas.validator.InputValidator.validateDateMatchedNumberRegex;
import static christmas.validator.InputValidator.validateValueEmpty;

public class DateValidator {
    public static void validateInputDate(final String input) {
        validateValueEmpty(input);
        validateDateMatchedNumberRegex(input);
    }

    public static void validateDate(final int date) {
        validateDateInMonth(date);
    }

    private static void validateDateInMonth(final int date) {
        if (MIN_DATE_IN_MONTH > date || MAX_DATE_IN_MONTH < date) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_DATE_MESSAGE.getMessage());
        }
    }
}