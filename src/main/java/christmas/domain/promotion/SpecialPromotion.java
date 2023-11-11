package christmas.domain.promotion;

import christmas.domain.Date;
import christmas.domain.DayInStar;
import christmas.domain.Menus;

public class SpecialPromotion implements Promotion {
    private final DayInStar dayInStar;

    public SpecialPromotion(DayInStar dayInStar) {
        this.dayInStar = dayInStar;
    }

    @Override
    public int discountAmount(Menus menus, Date date) {
        return 0;
    }
}