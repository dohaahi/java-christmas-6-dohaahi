package christmas.domain.promotion;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.date.Date;
import christmas.domain.menu.MenuItem;
import christmas.domain.menu.MenuItems;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PromotionProcessorTest {
    MenuItem steak;
    MenuItem barbecueLip;
    MenuItem cake;
    MenuItem cola;
    MenuItem tapas;
    PromotionProcessor promotionProcessor;

    @BeforeEach
    void beforeEach() {
        steak = MenuItem.from("티본스테이크-1");
        barbecueLip = MenuItem.from("바비큐립-1");
        cake = MenuItem.from("초코케이크-2");
        cola = MenuItem.from("제로콜라-1");
        tapas = MenuItem.from("타파스-1");
    }

    @DisplayName("크리스마스 디데이 할인 혜택 금액을 구할 수 있다.")
    @Test
    void Get_Christmas_Promotion_Discount_Amount() {
        // given
        ChristmasPromotion christmasPromotion = new ChristmasPromotion();
        promotionProcessor = new PromotionProcessor(
                new Date(3),
                new MenuItems(List.of(steak, barbecueLip, cake, cola)));

        // when
        int totalDiscountAmount = promotionProcessor.getDiscountAmount(christmasPromotion);

        // then
        assertThat(totalDiscountAmount).isEqualTo(1_200);
    }

    @DisplayName("주말 할인 혜택 금액을 구할 수 있다.")
    @Test
    void Get_Weekend_Promotion_Discount_Amount() {
        // given
        WeekendPromotion weekendPromotion = new WeekendPromotion();
        promotionProcessor = new PromotionProcessor(
                new Date(24),
                new MenuItems(List.of(steak, barbecueLip, cake, cola)));

        // when
        int totalDiscountAmount = promotionProcessor.getDiscountAmount(weekendPromotion);

        // then
        assertThat(totalDiscountAmount).isEqualTo(4_046);
    }

    @DisplayName("평일 할인 혜택 금액을 구할 수 있다.")
    @Test
    void Get_Weekday_Promotion_Discount_Amount() {
        // given
        WeekdayPromotion weekdayPromotion = new WeekdayPromotion();
        promotionProcessor = new PromotionProcessor(
                new Date(3),
                new MenuItems(List.of(steak, barbecueLip, cake, cola)));

        // when
        int totalDiscountAmount = promotionProcessor.getDiscountAmount(weekdayPromotion);

        // then
        assertThat(totalDiscountAmount).isEqualTo(4_046);
    }

    @DisplayName("스페셜 할인 혜택 금액을 구할 수 있다.")
    @Test
    void Get_Special_Promotion_Discount_Amount() {
        // given
        SpecialPromotion specialPromotion = new SpecialPromotion();
        promotionProcessor = new PromotionProcessor(new Date(3),
                new MenuItems(List.of(steak, barbecueLip, cake, cola)));

        // when
        int totalDiscountAmount = promotionProcessor.getDiscountAmount(specialPromotion);

        // then
        assertThat(totalDiscountAmount).isEqualTo(1_000);
    }

    @DisplayName("증정 이벤트 혜택 금액을 구할 수 있다.")
    @Test
    void test3() {
        // given
        GiftPromotion giftPromotion = new GiftPromotion();
        promotionProcessor = new PromotionProcessor(new Date(3),
                new MenuItems(List.of(steak, barbecueLip, cake, cola)));

        // when
        int totalDiscountAmount = promotionProcessor.getDiscountAmount(giftPromotion);

        // then
        assertThat(totalDiscountAmount).isEqualTo(25_000);
    }

    @DisplayName("할인 혜택이 아무것도 없는 경우 총 할인 금액은 0이다.")
    @Test
    void test() {
        // given
        promotionProcessor = new PromotionProcessor(new Date(26), new MenuItems(List.of(tapas, cola)));

        // when
        int totalDiscountAmount = promotionProcessor.getTotalDiscountAmount();

        // then
        assertThat(totalDiscountAmount).isEqualTo(0);
    }

    @DisplayName("주문한 메뉴에 따른 총 할인 혜택 금액을 구할 수 있다.")
    @Test
    void test2() {
        // given
        promotionProcessor = new PromotionProcessor(new Date(3),
                new MenuItems(List.of(steak, barbecueLip, cake, cola)));

        // when
        int totalDiscountAmount = promotionProcessor.getTotalDiscountAmount();

        // then
        assertThat(totalDiscountAmount).isEqualTo(31_246);
    }
}