package christmas.domain.promotion;

import christmas.domain.menu.Menu;
import christmas.domain.order.OrderElement;

public class GiftPromotion implements Promotion {
    public static final Menu GIFT_MENU = Menu.CHAMPAGNE;
    public static final int GIFT_COUNT = 1;
    public static final int MIN_ORDER_AMOUNT = 120_000;
    private final String name = PromotionName.GIFT_PROMOTION.getName();

    public static boolean isGiftPresent(final int totalPrice) {
        return totalPrice >= MIN_ORDER_AMOUNT;
    }

    @Override
    public int discountAmount(final OrderElement element) {

        if (element.isPriceLessThan(MIN_ORDER_AMOUNT)) {
            return NO_DISCOUNT;
        }

        return GIFT_MENU.getPrice();
    }

    public String getName() {
        return name;
    }
}