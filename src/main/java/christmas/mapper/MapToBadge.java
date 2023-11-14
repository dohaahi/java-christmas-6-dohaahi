package christmas.mapper;

import static christmas.mapper.MapToTotalDiscountAmount.mapToTotalDiscountAmount;

import christmas.domain.promotion.PromotionProcessor;

public class MapToBadge {
    public static String mapToBadge(final PromotionProcessor promotionProcessor) {
        return promotionProcessor.getBadge(mapToTotalDiscountAmount(promotionProcessor));
    }
}