package christmas.mapper;

import christmas.domain.promotion.PromotionProcessor;

public class MapToTotalDiscountAmount {
    public static int mapToTotalDiscountAmount(final PromotionProcessor promotionProcessor) {
        return promotionProcessor.getTotalDiscountAmount();
    }
}