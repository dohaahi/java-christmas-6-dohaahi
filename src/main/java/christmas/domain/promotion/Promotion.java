package christmas.domain.promotion;

import christmas.domain.Day;
import christmas.domain.MenuItems;

public interface Promotion {
    public static final int NO_DISCOUNT = 0;

    public int discountAmount(final MenuItems menuItems, final Day day);
}