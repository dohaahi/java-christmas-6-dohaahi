package christmas.domain;

import static christmas.validator.DateValidator.validateDate;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Day {
    public static final int CURRENT_MONTH = 12;
    private static final int CURRENT_YEAR = 2023;
    private final int day;

    public Day(int day) {
        validateDate(day);

        this.day = day;
    }

    public String getDayOfWeek() {
        return LocalDate.of(CURRENT_YEAR, CURRENT_MONTH, day)
                .getDayOfWeek()
                .getDisplayName(TextStyle.FULL, Locale.US);
    }

    public int getDay() {
        return day;
    }
}
