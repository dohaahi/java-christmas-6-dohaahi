package christmas.domain.promotion;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BadgePromotionTest {
    @DisplayName("총 할인 금액이 20_000원 이상이면 산타 배지를 준다.")
    @Test
    void Total_Discount_Amount_is_More_Than_Sante_Badge_Min_Discount_Amount() {
        // given
        int totalDiscountAmount = 20_000;
        BadgePromotion badgePromotion = new BadgePromotion();

        // when
        Badge badge = badgePromotion.getBadge(totalDiscountAmount);

        // then
        assertThat(badge).isEqualTo(Badge.SANTA);
    }

    @DisplayName("총 할인 금액이 10_000원 이상이면 트리 배지를 준다.")
    @Test
    void Total_Discount_Amount_is_More_Than_Tree_Badge_Min_Discount_Amount() {
        // given
        int totalDiscountAmount = 10_000;
        BadgePromotion badgePromotion = new BadgePromotion();

        // when
        Badge badge = badgePromotion.getBadge(totalDiscountAmount);

        // then
        assertThat(badge).isEqualTo(Badge.TREE);
    }

    @DisplayName("총 할인 금액이 5_000원 이상이면 별 배지를 준다.")
    @Test
    void Total_Discount_Amount_is_More_Than_Star_Badge_Min_Discount_Amount() {
        // given
        int totalDiscountAmount = 5_000;
        BadgePromotion badgePromotion = new BadgePromotion();

        // when
        Badge badge = badgePromotion.getBadge(totalDiscountAmount);

        // then
        assertThat(badge).isEqualTo(Badge.STAR);
    }

    @DisplayName("총 할인 금액이 5_000원 미만이면 배지를 주지 않는다.")
    @Test
    void Total_Discount_Amount_is_Less_Than_Star_Badge_Min_Discount_Amount() {
        // given
        int totalDiscountAmount = 4_999;
        BadgePromotion badgePromotion = new BadgePromotion();

        // when
        Badge badge = badgePromotion.getBadge(totalDiscountAmount);

        // then
        assertThat(badge).isEqualTo(Badge.NONE);
    }
}