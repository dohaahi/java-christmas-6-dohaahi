package christmas.domain.promotion;

import static christmas.domain.promotion.ChristmasPromotion.CHRISTMAS_DATE;

import christmas.domain.Day;
import christmas.domain.MenuItems;

public class SpecialPromotion implements Promotion {
    public static final int SPECIAL_DISCOUNT_AMOUNT = 1_000;

    @Override
    public int discountAmount(MenuItems menuItems, Day day) {
        if (!isValidSpecialDiscountPeriod(day)) {
            return NO_DISCOUNT;
        }

        return SPECIAL_DISCOUNT_AMOUNT;
    }

    private boolean isValidSpecialDiscountPeriod(final Day day) {
        return CHRISTMAS_DATE == day.getDate() || day.getDayOfWeek().equals("Sunday");
    }
}