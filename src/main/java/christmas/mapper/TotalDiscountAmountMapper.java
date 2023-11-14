package christmas.mapper;

import christmas.domain.promotion.PromotionProcessor;

public class TotalDiscountAmountMapper {
    public static int mapToTotalDiscountAmount(final PromotionProcessor promotionProcessor) {
        return promotionProcessor.getTotalDiscountAmount();
    }
}