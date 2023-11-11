package christmas.domain.promotion;

import christmas.domain.Date;
import christmas.domain.Menus;

public interface Promotion {
    public int discountAmount(final Menus menus, final Date date);
}