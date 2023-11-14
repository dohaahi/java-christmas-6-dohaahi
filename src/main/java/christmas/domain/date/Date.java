package christmas.domain.date;

import static christmas.validator.DateValidator.validateDate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class Date {
    public static final int CURRENT_MONTH = 12;
    public static final int MIN_DATE_IN_MONTH = 1;
    public static final int MAX_DATE_IN_MONTH = 31;
    private static final int CURRENT_YEAR = 2023;
    private final int day;

    public Date(final int day) {
        validateDate(day);

        this.day = day;
    }

    public boolean isWeekend(final Date date) {
        final List<DayOfWeek> weekend = List.of(DayOfWeek.FRIDAY, DayOfWeek.SATURDAY);

        return weekend.contains(date.getDayOfWeek());
    }

    public DayOfWeek getDayOfWeek() {
        return LocalDate.of(CURRENT_YEAR, CURRENT_MONTH, day).getDayOfWeek();
    }

    public boolean isMatch(final int day) {
        return this.day == day;
    }

    public boolean isMatch(final DayOfWeek dayOfWeek) {
        return getDayOfWeek().equals(dayOfWeek);
    }

    public boolean isPassed(final int day) {
        return this.day > day;
    }

    public int minus(final int day) {
        return this.day - day;
    }

    public int getDay() {
        return day;
    }
}