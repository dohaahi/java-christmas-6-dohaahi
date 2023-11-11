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

public class WeekdayPromotion {
    private final DayOfWeek startPeriod = DayOfWeek.FRIDAY;
    private final DayOfWeek endPeriod = DayOfWeek.SATURDAY;
    private final MenuCategory discountItem = MenuCategory.MAIN;
    private final int discountAmount = 2_023;
}