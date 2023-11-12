package christmas.domain.promotion;

import christmas.domain.date.Date;
import christmas.domain.menu.MenuItems;
import christmas.domain.order.OrderElement;
import java.util.List;

public class PromotionProcessor {
    private final OrderElement orderElement;
    private final List<Promotion> promotions = List.of(
            new ChristmasPromotion(),
            new PeriodPromotion(),
            new SpecialPromotion(),
            new GiftPromotion()
    );

    public PromotionProcessor(final MenuItems menuItems, final Date date) {
        this.orderElement = new OrderElement(menuItems, date);
    }

    public void discount() {
        final int christmasPromotionDiscountAmount = getDiscountAmountFrom(new ChristmasPromotion());
        final int periodPromotionDiscountAmount = getDiscountAmountFrom(new PeriodPromotion());
        final int specialPromotionDiscountAmount = getDiscountAmountFrom(new SpecialPromotion());
        final int giftPromotionDiscountAmount = getDiscountAmountFrom(new GiftPromotion());

        final DiscountRecord discountRecord = new DiscountRecord(
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