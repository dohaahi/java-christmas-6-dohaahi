package christmas.domain.dto;

public record PromotionRecordDto(
        int christmasPromotionDiscountAmount,
        int periodPromotionDiscountAmount,
        int specialPromotionDiscountAmount,
        int giftPromotionDiscountAmount,
        int totalDiscountAmount) {
}