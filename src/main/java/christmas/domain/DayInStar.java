package christmas.domain;

import static christmas.domain.promotion.ChristmasPromotion.CHRISTMAS_DATE;
import static christmas.domain.promotion.MonthPromotion.MAX_DATE_IN_MONTH;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DayInStar {
    private final List<Date> days;
    private final int discountAmount = 1_000;

    public DayInStar() {
        final int firstDayInStar = 3;

        List<Date> days = new ArrayList<>();
        for (int date = firstDayInStar; date < MAX_DATE_IN_MONTH; date += 7) {
            days.add(new Date(date));
        }
        days.add(new Date(CHRISTMAS_DATE));

        this.days = days;
    }
}