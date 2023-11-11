package christmas.domain.promotion;

import christmas.domain.Date;
import christmas.domain.DayOfWeek;
import christmas.domain.Menus;
import christmas.domain.menu.MenuCategory;

public class WeekendPromotion implements Promotion {
    private final DayOfWeek startPeriod = DayOfWeek.FRIDAY;
    private final DayOfWeek endPeriod = DayOfWeek.SATURDAY;
    private final MenuCategory discountMenuCategory = MenuCategory.MAIN;
    private final int discountAmount = 2_023;

    @Override
    public int discountAmount(Menus menus, Date date) {
        return 0;
    }
}