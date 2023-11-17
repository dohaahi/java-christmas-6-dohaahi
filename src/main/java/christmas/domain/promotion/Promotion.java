package christmas.domain.promotion;

import christmas.domain.order.OrderElement;

public interface Promotion {
    public static final int NO_DISCOUNT = 0;

    public int discountAmount(final OrderElement element);

    public String getName();
}