package christmas.domain.promotion;

import christmas.domain.Date;
import christmas.domain.MenuItems;
import christmas.domain.menu.MenuCategory;
import java.time.DayOfWeek;
import java.util.List;

public class PeriodPromotion implements Promotion {
    public static final MenuCategory WEEKDAY_DISCOUNT_CATEGORY = MenuCategory.DESSERT;
    public static final MenuCategory WEEKEND_DISCOUNT_CATEGORY = MenuCategory.MAIN;
    public static final int WEEKDAY_DISCOUNT_AMOUNT = 2_023;
    public static final int WEEKEND_DISCOUNT_AMOUNT = 2_023;

    @Override
    public int discountAmount(christmas.domain.MenuItems menuItems, Date date) {
        if (isWeekend(date)) {
            return weekendDiscountAmount(menuItems, date);
        }

        return weekdayDiscountAmount(menuItems, date);
    }

    private boolean isWeekend(final Date date) {
        final List<DayOfWeek> weekend = List.of(DayOfWeek.FRIDAY, DayOfWeek.SATURDAY);

        return weekend.contains(date.getDayOfWeek());
    }

    private int weekendDiscountAmount(final MenuItems menuItems, final Date date) {
        return (int) menuItems.getMenuItems().stream()
                .filter(menuItem -> menuItem.isMatch(WEEKEND_DISCOUNT_CATEGORY))
                .count() * WEEKEND_DISCOUNT_AMOUNT;
    }

    private int weekdayDiscountAmount(final MenuItems menuItems, final Date date) {
        return (int) menuItems.getMenuItems().stream()
                .filter(menuItem -> menuItem.isMatch(WEEKDAY_DISCOUNT_CATEGORY))
                .count() * WEEKDAY_DISCOUNT_AMOUNT;
    }
}