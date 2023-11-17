package christmas.domain.promotion;

import christmas.domain.date.Date;
import christmas.domain.order.OrderElement;

public class ChristmasPromotion implements Promotion {
    public static final int CHRISTMAS_DATE = 25;
    public static final int DISCOUNT_AMOUNT_INIT = 1_000;
    public static final int DAILY_DISCOUNT_AMOUNT = 100;
    private final String name = PromotionName.CHRISTMAS_PROMOTION.getName();

    @Override
    public int discountAmount(final OrderElement element) {
        final Date date = element.getDate();

        if (date.isPassed(CHRISTMAS_DATE)) {
            return NO_DISCOUNT;
        }

        return DISCOUNT_AMOUNT_INIT + (date.minus(1) * DAILY_DISCOUNT_AMOUNT);
    }

    public String getName() {
        return name;
    }
}