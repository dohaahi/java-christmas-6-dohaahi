package christmas.mapper;

import christmas.domain.dto.PromotionDto;
import christmas.domain.promotion.Promotion;
import christmas.domain.promotion.PromotionProcessor;
import java.util.List;

public class MapToPromotions {
    public static List<PromotionDto> mapToPromotions(final PromotionProcessor promotionProcessor) {

        List<Promotion> promotions = promotionProcessor.getPromotions();

        return promotions.stream()
                .map(promotion -> toPromotionDto(promotionProcessor, promotion))
                .toList();
    }

    private static PromotionDto toPromotionDto(final PromotionProcessor promotionProcessor, Promotion promotion) {
        return new PromotionDto(promotion.getName(), promotionProcessor.getDiscountAmount(promotion));
    }
}