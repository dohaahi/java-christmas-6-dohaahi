package christmas.domain.promotion;

import christmas.domain.Date;
import christmas.domain.menu.Menu;

public class GiftPromotion implements Promotion {
    private static final int MIN_ORDER_AMOUNT = 120_000;
    private final Menu giftItem = Menu.CHAMPAGNE;
    private final int giftCount = 1;

    @Override
    public int discountAmount(christmas.domain.MenuItems menuItems, Date date) {
        if (menuItems.getTotalPrice() < MIN_ORDER_AMOUNT) {
            return NO_DISCOUNT;
        }

        return giftItem.getPrice();
    }
}