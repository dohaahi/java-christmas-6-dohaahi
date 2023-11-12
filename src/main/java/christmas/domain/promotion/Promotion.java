package christmas.domain.promotion;

import christmas.domain.date.Date;
import christmas.domain.menu.MenuItems;

public interface Promotion {
    public static final int NO_DISCOUNT = 0;

    public int discountAmount(final MenuItems menuItems, final Date date);
}