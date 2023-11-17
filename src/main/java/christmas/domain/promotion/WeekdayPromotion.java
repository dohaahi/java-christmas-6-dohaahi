package christmas.domain.promotion;

import christmas.domain.menu.MenuCategory;
import christmas.domain.menu.MenuItem;
import christmas.domain.order.OrderElement;

public class WeekdayPromotion implements Promotion {
    public static final MenuCategory WEEKDAY_DISCOUNT_CATEGORY = MenuCategory.DESSERT;
    public static final int WEEKDAY_DISCOUNT_AMOUNT = 2_023;
    private final String name = PromotionName.WEEKDAY_PROMOTION.getName();

    @Override
    public int discountAmount(OrderElement element) {
        return (int) element.getMenuItems()
                .stream()
                .filter(menuItem -> menuItem.isMatch(WEEKDAY_DISCOUNT_CATEGORY))
                .mapToInt(MenuItem::getCount)
                .sum() * WEEKDAY_DISCOUNT_AMOUNT;
    }

    public String getName() {
        return name;
    }
}
