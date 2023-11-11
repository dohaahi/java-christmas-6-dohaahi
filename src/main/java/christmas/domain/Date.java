package christmas.domain;

import static christmas.validator.DateValidator.validateDate;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Date {
    private static final int CURRENT_YEAR = 2023;
    public static final int CURRENT_MONTH = 12;

    private final int date;

    public Date(int date) {
        validateDate(date);

        this.date = date;
    }

    public String getDayOfWeek() {
        return LocalDate.of(CURRENT_YEAR, CURRENT_MONTH, date)
                .getDayOfWeek()
                .getDisplayName(TextStyle.FULL, Locale.US);
    }

    public int getDate() {
        return date;
    }
}
