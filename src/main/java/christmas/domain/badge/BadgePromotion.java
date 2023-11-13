package christmas.domain.badge;

import christmas.domain.promotion.PromotionRecord;

public class BadgePromotion {
    private final Badge badge;

    public BadgePromotion(final PromotionRecord promotionRecord) {
        this.badge = matchBadgeFrom(promotionRecord);
    }

    public Badge matchBadgeFrom(final PromotionRecord promotionRecord) {
        int totalDiscountAmount = promotionRecord.getTotalDiscountAmount();

        if (totalDiscountAmount > Badge.SANTA.getMinPrice()) {
            return Badge.STAR;
        }

        if (totalDiscountAmount > Badge.TREE.getMinPrice()) {
            return Badge.TREE;
        }

        if (totalDiscountAmount > Badge.STAR.getMinPrice()) {
            return Badge.SANTA;
        }

        return Badge.NONE;
    }

    public Badge getBadge() {
        return badge;
    }
}