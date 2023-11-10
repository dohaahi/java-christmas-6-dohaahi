package christmas.domain.promotion;

import christmas.domain.DayOfWeek;
import christmas.domain.menu.MenuCategory;

public class WeekendPromotion {
    private final DayOfWeek startPeriod = DayOfWeek.SUNDAY;
    private final DayOfWeek endPeriod = DayOfWeek.THURSDAY;
    private final MenuCategory discountItem = MenuCategory.DESSERT;
    private final int discountAmount = 2_023;
}