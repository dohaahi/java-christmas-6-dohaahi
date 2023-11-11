package christmas.domain.promotion;

import static christmas.domain.promotion.ChristmasPromotion.CHRISTMAS_DATE;

import christmas.domain.Date;
import christmas.domain.MenuItems;

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
        return CHRISTMAS_DATE == date.getDay() || date.getDayOfWeek().equals("Sunday");
    }
}