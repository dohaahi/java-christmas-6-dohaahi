package christmas.domain.promotion;

import java.util.List;

public class PromotionRecord {
    private final int christmasPromotionDiscountAmount;
    private final int periodPromotionDiscountAmount;
    private final int specialPromotionDiscountAmount;
    private final int giftPromotionDiscountAmount;
    private final int totalDiscountAmount;

    public PromotionRecord(int christmasPromotionDiscountAmount, int periodPromotionDiscountAmount,
                           int specialPromotionDiscountAmount, int giftPromotionDiscountAmount
    ) {
        this.christmasPromotionDiscountAmount = christmasPromotionDiscountAmount;
        this.periodPromotionDiscountAmount = periodPromotionDiscountAmount;
        this.specialPromotionDiscountAmount = specialPromotionDiscountAmount;
        this.giftPromotionDiscountAmount = giftPromotionDiscountAmount;

        final List<Integer> discountAmounts = List.of(christmasPromotionDiscountAmount,
                periodPromotionDiscountAmount, specialPromotionDiscountAmount, giftPromotionDiscountAmount);

        this.totalDiscountAmount = calculateDiscountAmount(discountAmounts);
    }

    private int calculateDiscountAmount(final List<Integer> discountAmounts) {
        return discountAmounts.stream().mapToInt(Integer::intValue).sum();
    }

    public int getChristmasPromotionDiscountAmount() {
        return christmasPromotionDiscountAmount;
    }

    public int getPeriodPromotionDiscountAmount() {
        return periodPromotionDiscountAmount;
    }

    public int getSpecialPromotionDiscountAmount() {
        return specialPromotionDiscountAmount;
    }

    public int getGiftPromotionDiscountAmount() {
        return giftPromotionDiscountAmount;
    }

    public int calculateDiscountAmount() {
        return totalDiscountAmount;
    }
}