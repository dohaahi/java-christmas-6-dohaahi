package christmas.domain.promotion;

import christmas.domain.Date;
import christmas.domain.Menus;
import christmas.domain.menu.MenuItem;

public class GiftPromotion implements Promotion {
    private static final int MIN_ORDER_AMOUNT = 120_000;
    private final MenuItem giftItem = MenuItem.CHAMPAGNE;
    private final int giftCount = 1;

    @Override
    public int discountAmount(Menus menus, Date date) {
        return 0;
    }
}