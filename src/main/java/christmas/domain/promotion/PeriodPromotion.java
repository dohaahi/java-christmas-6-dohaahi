package christmas.domain.promotion;

import christmas.domain.Date;
import christmas.domain.Menus;
import christmas.domain.menu.MenuCategory;
import christmas.domain.menu.MenuItem;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class PeriodPromotion implements Promotion {
    public static final MenuCategory WEEKDAY_DISCOUNT_CATEGORY = MenuCategory.DESSERT;
    public static final MenuCategory WEEKEND_DISCOUNT_CATEGORY = MenuCategory.MAIN;
    public static final int WEEKDAY_DISCOUNT_AMOUNT = 2_023;
    public static final int WEEKEND_DISCOUNT_AMOUNT = 2_023;

    @Override
    public int discountAmount(Menus menus, Date date) {
        if (isWeekend(date)) {
            return weekendDiscountAmount(menus, date);
        }

        return weekdayDiscountAmount(menus, date);
    }

    private boolean isWeekend(final Date date) {
        final List<String> weekend = List.of("Friday", "Saturday");

        return weekend.contains(date.getDayOfWeek());
    }

    private int weekendDiscountAmount(final Menus menus, final Date date) {
        int discountAmount = 0;

        Set<Entry<MenuItem, Integer>> entries = menus.getMenus().entrySet();
        for (Entry<MenuItem, Integer> entry : entries) {
            if (entry.getKey().getCategory().equals(WEEKEND_DISCOUNT_CATEGORY)) {
                discountAmount += WEEKEND_DISCOUNT_AMOUNT * entry.getValue();
            }
        }

        return discountAmount;
    }

    private int weekdayDiscountAmount(final Menus menus, final Date date) {
        int discountAmount = 0;

        Set<Entry<MenuItem, Integer>> entries = menus.getMenus().entrySet();
        for (Entry<MenuItem, Integer> entry : entries) {
            if (entry.getKey().getCategory().equals(WEEKDAY_DISCOUNT_CATEGORY)) {
                discountAmount += WEEKDAY_DISCOUNT_AMOUNT * entry.getValue();
            }
        }

        return discountAmount;
    }
}