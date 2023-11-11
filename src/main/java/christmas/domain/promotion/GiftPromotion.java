package christmas.domain.promotion;

import christmas.domain.Day;
import christmas.domain.MenuItems;
import christmas.domain.menu.Menu;

public class GiftPromotion implements Promotion {
    private static final int MIN_ORDER_AMOUNT = 120_000;
    private final Menu giftItem = Menu.CHAMPAGNE;
    private final int giftCount = 1;

    @Override
    public int discountAmount(MenuItems menuItems, Day day) {
        if (menuItems.getTotalPrice() < MIN_ORDER_AMOUNT) {
            return NO_DISCOUNT;
        }

        return giftItem.getMenuPrice();
    }
}