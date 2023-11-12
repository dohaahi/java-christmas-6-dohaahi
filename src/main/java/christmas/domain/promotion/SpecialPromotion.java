package christmas.domain.promotion;

import static christmas.domain.promotion.ChristmasPromotion.CHRISTMAS_DATE;

import christmas.domain.date.Date;
import christmas.domain.menu.MenuItems;
import java.time.DayOfWeek;

public class SpecialPromotion implements Promotion {
    public static final int SPECIAL_DISCOUNT_AMOUNT = 1_000;

    @Override
    public int discountAmount(MenuItems menuItems, Date date) {
        if (!isValidSpecialDiscountPeriod(date)) {
            return NO_DISCOUNT;
        }

        return SPECIAL_DISCOUNT_AMOUNT;
    }

    private boolean isValidSpecialDiscountPeriod(final Date date) {
        return date.isMatch(CHRISTMAS_DATE) || date.isMatch(DayOfWeek.SUNDAY);
    }
}