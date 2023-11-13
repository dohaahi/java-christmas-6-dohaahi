package christmas.domain;

import christmas.domain.dto.BadgePromotionDto;
import christmas.domain.dto.OrderDto;
import christmas.domain.dto.PromotionRecordDto;

public record OrderRecord(OrderDto order, PromotionRecordDto promotionRecord, BadgePromotionDto badgePromotion) {
}
