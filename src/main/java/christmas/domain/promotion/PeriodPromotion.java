package christmas.domain.promotion;

import static christmas.domain.date.Date.isWeekend;

import christmas.domain.date.Date;
import christmas.domain.menu.MenuCategory;
import christmas.domain.menu.MenuItems;
import christmas.domain.order.OrderElement;

public class PeriodPromotion implements Promotion {
    public static final MenuCategory WEEKDAY_DISCOUNT_CATEGORY = MenuCategory.DESSERT;
    public static final MenuCategory WEEKEND_DISCOUNT_CATEGORY = MenuCategory.MAIN;
    public static final int WEEKDAY_DISCOUNT_AMOUNT = 2_023;
    public static final int WEEKEND_DISCOUNT_AMOUNT = 2_023;

    @Override
    public int discountAmount(final OrderElement element) {
        MenuItems menuItems = element.getMenuItems();
        Date date = element.getDate();

        if (isWeekend(date)) {
            return weekendDiscountAmount(menuItems, date);
        }

        return weekdayDiscountAmount(menuItems, date);
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