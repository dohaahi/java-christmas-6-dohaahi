package christmas.domain.promotion;

import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuItems;
import christmas.domain.order.OrderElement;

public class GiftPromotion implements Promotion {
    public static final Menu GIFT_MENU = Menu.CHAMPAGNE;
    public static final int GIFT_COUNT = 1;
    private static final int MIN_ORDER_AMOUNT = 120_000;

    public static boolean isGiftPresent(final int totalPrice) {
        return totalPrice >= MIN_ORDER_AMOUNT;
    }

    @Override
    public int discountAmount(final OrderElement element) {
        final MenuItems menuItems = element.getMenuItems();

        if (menuItems.isLessThan(MIN_ORDER_AMOUNT)) {
            return NO_DISCOUNT;
        }

        return GIFT_MENU.getPrice();
    }
}