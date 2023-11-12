package christmas.domain.promotion;

import christmas.domain.date.Date;
import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuItems;

public class GiftPromotion implements Promotion {
    private static final int MIN_ORDER_AMOUNT = 120_000;
    private final Menu giftItem = Menu.CHAMPAGNE;
    private final int giftCount = 1;

    @Override
    public int discountAmount(MenuItems menuItems, Date date) {
        if (menuItems.isLessThan(MIN_ORDER_AMOUNT)) {
            return NO_DISCOUNT;
        }

        return giftItem.getPrice();
    }
}