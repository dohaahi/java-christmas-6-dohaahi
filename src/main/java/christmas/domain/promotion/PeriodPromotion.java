package christmas.domain.promotion;

import christmas.domain.Day;
import christmas.domain.MenuItems;
import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuCategory;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class PeriodPromotion implements Promotion {
    public static final MenuCategory WEEKDAY_DISCOUNT_CATEGORY = MenuCategory.DESSERT;
    public static final MenuCategory WEEKEND_DISCOUNT_CATEGORY = MenuCategory.MAIN;
    public static final int WEEKDAY_DISCOUNT_AMOUNT = 2_023;
    public static final int WEEKEND_DISCOUNT_AMOUNT = 2_023;

    @Override
    public int discountAmount(MenuItems menuItems, Day day) {
        if (isWeekend(day)) {
            return weekendDiscountAmount(menuItems, day);
        }

        return weekdayDiscountAmount(menuItems, day);
    }

    private boolean isWeekend(final Day day) {
        final List<String> weekend = List.of("Friday", "Saturday");

        return weekend.contains(day.getDayOfWeek());
    }

    private int weekendDiscountAmount(final MenuItems menuItems, final Day day) {
        int discountAmount = 0;

        Set<Entry<Menu, Integer>> entries = menuItems.getMenus().entrySet();
        for (Entry<Menu, Integer> entry : entries) {
            if (entry.getKey().getCategory().equals(WEEKEND_DISCOUNT_CATEGORY)) {
                discountAmount += WEEKEND_DISCOUNT_AMOUNT * entry.getValue();
            }
        }

        return discountAmount;
    }

    private int weekdayDiscountAmount(final MenuItems menuItems, final Day day) {
        int discountAmount = 0;

        Set<Entry<Menu, Integer>> entries = menuItems.getMenus().entrySet();
        for (Entry<Menu, Integer> entry : entries) {
            if (entry.getKey().getCategory().equals(WEEKDAY_DISCOUNT_CATEGORY)) {
                discountAmount += WEEKDAY_DISCOUNT_AMOUNT * entry.getValue();
            }
        }

        return discountAmount;
    }
}