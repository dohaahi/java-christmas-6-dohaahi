package christmas.domain;

import static christmas.validator.DateValidator.validateDate;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Date {
    public static final int CURRENT_MONTH = 12;
    private static final int CURRENT_YEAR = 2023;
    private final int day;

    public Date(int day) {
        validateDate(day);

        this.day = day;
    }

    public DayOfWeek getDayOfWeek() {
        return LocalDate.of(CURRENT_YEAR, CURRENT_MONTH, day)
                .getDayOfWeek();
    }

    public int getDay() {
        return day;
    }
}