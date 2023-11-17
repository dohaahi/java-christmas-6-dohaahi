package christmas.validator;

import static christmas.domain.date.Date.MAX_DATE_IN_MONTH;
import static christmas.domain.date.Date.MIN_DATE_IN_MONTH;

import christmas.exception.IllegalDateException;
import java.util.regex.Pattern;

public class DateValidator {
    public static final String NUMBER_REGEX = "^[\\d]*$";

    public static void validateInputDate(final String input) {
        validateValueEmpty(input);
        validateDateMatchedNumberRegex(input);
    }

    public static void validateValueEmpty(final String input) {
        if (input.isEmpty()) {
            throw new IllegalDateException();
        }
    }

    public static void validateDateMatchedNumberRegex(final String input) {
        if (!Pattern.matches(NUMBER_REGEX, input)) {
            throw new IllegalDateException();
        }
    }

    public static void validateDate(final int date) {
        validateDateInMonth(date);
    }

    private static void validateDateInMonth(final int date) {
        if (MIN_DATE_IN_MONTH > date || MAX_DATE_IN_MONTH < date) {
            throw new IllegalDateException();
        }
    }
}