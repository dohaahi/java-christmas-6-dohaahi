package christmas.domain.promotion;

import christmas.domain.Date;
import christmas.domain.Menus;

public class ChristmasPromotion implements Promotion {
    private static final int PROMOTION_START_DATE = 1;
    public static final int CHRISTMAS_DATE = 25;
    private static final int DISCOUNT_AMOUNT_INIT = 1_000;
    private static final int DAILY_DISCOUNT_AMOUNT = 100;

    @Override
    public int discountAmount(final Menus menus, final Date date) {
        return DISCOUNT_AMOUNT_INIT + (date.getDate() * DAILY_DISCOUNT_AMOUNT);
    }
}