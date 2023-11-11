package christmas.domain.promotion;

import christmas.domain.Date;
import christmas.domain.MenuItems;

public class ChristmasPromotion implements Promotion {
    public static final int CHRISTMAS_DATE = 25;
    private static final int DISCOUNT_AMOUNT_INIT = 1_000;
    private static final int DAILY_DISCOUNT_AMOUNT = 100;

    @Override
    public int discountAmount(final MenuItems menuItems, final Date date) {
        if (date.getDate() > CHRISTMAS_DATE) {
            return NO_DISCOUNT;
        }

        return DISCOUNT_AMOUNT_INIT + (date.getDate() * DAILY_DISCOUNT_AMOUNT);
    }
}