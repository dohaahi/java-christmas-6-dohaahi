package christmas.domain.promotion;

import christmas.domain.Date;
import christmas.domain.menu.MenuCategory;
import christmas.domain.menu.MenuItems;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

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
        final List<String> weekend = List.of("Friday", "Saturday");

        return weekend.contains(date.getDayOfWeek());
    }

    private int weekendDiscountAmount(final christmas.domain.MenuItems menuItems, final Date date) {
        int discountAmount = 0;

        Set<Entry<MenuItems, Integer>> entries = menuItems.getMenus().entrySet();
        for (Entry<MenuItems, Integer> entry : entries) {
            if (entry.getKey().getCategory().equals(WEEKEND_DISCOUNT_CATEGORY)) {
                discountAmount += WEEKEND_DISCOUNT_AMOUNT * entry.getValue();
            }
        }

        return discountAmount;
    }

    private int weekdayDiscountAmount(final christmas.domain.MenuItems menuItems, final Date date) {
        int discountAmount = 0;

        Set<Entry<MenuItems, Integer>> entries = menuItems.getMenus().entrySet();
        for (Entry<MenuItems, Integer> entry : entries) {
            if (entry.getKey().getCategory().equals(WEEKDAY_DISCOUNT_CATEGORY)) {
                discountAmount += WEEKDAY_DISCOUNT_AMOUNT * entry.getValue();
            }
        }

        return discountAmount;
    }
}