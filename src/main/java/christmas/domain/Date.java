package christmas.domain;

import static christmas.validator.DateValidator.validateDate;

public class Date {
    private final int date;

    public Date(int date) {
        validateDate(date);

        this.date = date;
    }

    public int getDate() {
        return date;
    }
}
