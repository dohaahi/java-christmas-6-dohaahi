package christmas.domain.promotion;

import christmas.domain.DayOfWeek;
import christmas.domain.menu.MenuCategory;

public class WeekdayPromotion {
    private final DayOfWeek startPeriod = DayOfWeek.FRIDAY;
    private final DayOfWeek endPeriod = DayOfWeek.SATURDAY;
    private final MenuCategory discountItem = MenuCategory.MAIN;
    private final int discountAmount = 2_023;
}