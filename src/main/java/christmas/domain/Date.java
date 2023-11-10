package christmas.domain;

public class Date {
    public static final int MIN_DATE_IN_MONTH = 1;
    public static final int MAX_DATE_IN_MONTH = 31;
    private final int date;

    public Date(int date) {
        this.date = date;
    }
}
