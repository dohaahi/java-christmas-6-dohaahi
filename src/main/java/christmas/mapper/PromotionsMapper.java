package christmas.mapper;

import christmas.domain.dto.PromotionDto;
import christmas.domain.promotion.Promotion;
import christmas.domain.promotion.PromotionProcessor;
import java.util.List;

public class PromotionsMapper {
    public static List<PromotionDto> mapToPromotions(final PromotionProcessor promotionProcessor) {

        final List<Promotion> promotions = promotionProcessor.getPromotions();

        return promotions.stream()
                .map(promotion -> toPromotionDto(promotionProcessor, promotion))
                .toList();
    }

    private static PromotionDto toPromotionDto(final PromotionProcessor promotionProcessor, final Promotion promotion) {
        return new PromotionDto(promotion.getName(), promotionProcessor.getDiscountAmount(promotion));
    }
}