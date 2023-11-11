package christmas.domain.promotion;

import christmas.domain.Date;
import christmas.domain.DayOfWeek;
import christmas.domain.Menus;
import christmas.domain.menu.MenuCategory;
import christmas.domain.menu.MenuItem;
import java.util.Map.Entry;
import java.util.Set;

public class WeekdayPromotion implements Promotion {
    public static final MenuCategory WEEKDAY_DISCOUNT_CATEGORY = MenuCategory.DESSERT;
    public static final int WEEKDAY_DISCOUNT_AMOUNT = 2_023;
    private final DayOfWeek startPeriod = DayOfWeek.SUNDAY;
    private final DayOfWeek endPeriod = DayOfWeek.THURSDAY;

    @Override
    public int discountAmount(Menus menus, Date date) {
        int totalDiscountAmount = 0;

        Set<Entry<MenuItem, Integer>> entries = menus.getMenus().entrySet();
        for (Entry<MenuItem, Integer> entry : entries) {
            if (entry.getKey().getCategory().equals(WEEKDAY_DISCOUNT_CATEGORY)) {
                totalDiscountAmount += WEEKDAY_DISCOUNT_AMOUNT * entry.getValue();
            }
        }

        return totalDiscountAmount;
    }
}