package christmas.domain.promotion;

import christmas.domain.date.Date;
import christmas.domain.menu.MenuItems;
import christmas.domain.order.OrderElement;
import java.util.List;

public class PromotionProcessor {
    private final OrderElement orderElement;
    private final Promotion christmasPromotion = new ChristmasPromotion();
    private final Promotion periodPromotion = new PeriodPromotion();
    private final Promotion specialPromotion = new SpecialPromotion();
    private final Promotion giftPromotion = new GiftPromotion();
    private final List<Promotion> promotions = List.of(
            christmasPromotion,
            periodPromotion,
            specialPromotion,
            giftPromotion
    );

    public PromotionProcessor(final Date date, final MenuItems menuItems) {
        this.orderElement = new OrderElement(date, menuItems);
    }

    public PromotionRecord discount() {
        final int christmasPromotionDiscountAmount = getDiscountAmountFrom(christmasPromotion);
        final int periodPromotionDiscountAmount = getDiscountAmountFrom(periodPromotion);
        final int specialPromotionDiscountAmount = getDiscountAmountFrom(specialPromotion);
        final int giftPromotionDiscountAmount = getDiscountAmountFrom(giftPromotion);

        return new PromotionRecord(
                christmasPromotionDiscountAmount,
                periodPromotionDiscountAmount,
                specialPromotionDiscountAmount,
                giftPromotionDiscountAmount);
    }

    private int getDiscountAmountFrom(final Promotion promotionType) {
        return promotions.stream()
                .filter(promotion -> promotion.equals(promotionType))
                .findFirst()
                .orElseThrow()
                .discountAmount(orderElement);
    }
}