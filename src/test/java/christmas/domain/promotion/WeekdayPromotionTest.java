package christmas.domain.promotion;

import static christmas.domain.promotion.WeekdayPromotion.WEEKDAY_DISCOUNT_AMOUNT;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.Date;
import christmas.domain.Menus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WeekdayPromotionTest {
    Date date;
    WeekdayPromotion weekdayPromotion;

    @BeforeEach
    void beforeEach() {
        weekdayPromotion = new WeekdayPromotion();
        date = new Date(4); // 월요일
    }

    @DisplayName("평일에 할인 하는 메뉴를 시키면 개당 " + WEEKDAY_DISCOUNT_AMOUNT + "원을 할인해준다.")
    @Test
    void  Order_Weekday_Discount_Menu() {
        // given
        Menus menus1 = new Menus("크리스마스파스타-3"); // 디저트 0개
        Menus menus2 = new Menus("초코케이크-1"); // 디저트 1개
        Menus menus3 = new Menus("크리스마스파스타-3, 초코케이크-3, 아이스크림-2"); // 디저트 5개

        // when
        int discountAmount1 = weekdayPromotion.discountAmount(menus1, date);
        int discountAmount2 = weekdayPromotion.discountAmount(menus2, date);
        int discountAmount3 = weekdayPromotion.discountAmount(menus3, date);

        // then
        assertThat(discountAmount1).isEqualTo(0 * WEEKDAY_DISCOUNT_AMOUNT);
        assertThat(discountAmount2).isEqualTo(1 * WEEKDAY_DISCOUNT_AMOUNT);
        assertThat(discountAmount3).isEqualTo(5 * WEEKDAY_DISCOUNT_AMOUNT);
    }
}