package christmas.domain.promotion;

import christmas.domain.menu.MenuCategory;
import christmas.domain.menu.MenuItem;
import christmas.domain.order.OrderElement;

public class WeekendPromotion implements Promotion {
    public static final MenuCategory WEEKEND_DISCOUNT_CATEGORY = MenuCategory.MAIN;
    public static final int WEEKEND_DISCOUNT_AMOUNT = 2_023;
    private final String name = PromotionName.WEEKEND_PROMOTION.getName();

    @Override
    public int discountAmount(OrderElement element) {
        return (int) element.getMenuItems()
                .stream()
                .filter(menuItem -> menuItem.isMatch(WEEKEND_DISCOUNT_CATEGORY))
                .mapToInt(MenuItem::getCount)
                .sum() * WEEKEND_DISCOUNT_AMOUNT;
    }

    public String getName() {
        return name;
    }
}
