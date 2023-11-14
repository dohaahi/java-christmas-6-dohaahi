package christmas.mapper;

import static christmas.mapper.TotalDiscountAmountMapper.mapToTotalDiscountAmount;

import christmas.domain.promotion.PromotionProcessor;

public class BadgeMapper {
    public static String mapToBadge(final PromotionProcessor promotionProcessor) {
        return promotionProcessor.getBadge(mapToTotalDiscountAmount(promotionProcessor));
    }
}