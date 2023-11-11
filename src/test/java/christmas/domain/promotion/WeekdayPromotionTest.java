package christmas.domain.promotion;

import static christmas.domain.promotion.WeekdayPromotion.WEEKDAY_DISCOUNT_AMOUNT;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.Day;
import christmas.domain.MenuItems;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WeekdayPromotionTest {
    Day day;
    WeekdayPromotion weekdayPromotion;

    @BeforeEach
    void beforeEach() {
        weekdayPromotion = new WeekdayPromotion();
        day = new Day(4); // 월요일
    }

    @DisplayName("평일에 할인 하는 메뉴를 시키면 개당 " + WEEKDAY_DISCOUNT_AMOUNT + "원을 할인해준다.")
    @Test
    void Order_Weekday_Discount_Menu() {
        // given
        MenuItems menuItems1 = new MenuItems("크리스마스파스타-3"); // 디저트 0개
        MenuItems menuItems2 = new MenuItems("초코케이크-1"); // 디저트 1개
        MenuItems menuItems3 = new MenuItems("크리스마스파스타-3, 초코케이크-3, 아이스크림-2"); // 디저트 5개

        // when
        int discountAmount1 = weekdayPromotion.discountAmount(menuItems1, day);
        int discountAmount2 = weekdayPromotion.discountAmount(menuItems2, day);
        int discountAmount3 = weekdayPromotion.discountAmount(menuItems3, day);

        // then
        assertThat(discountAmount1).isEqualTo(0 * WEEKDAY_DISCOUNT_AMOUNT);
        assertThat(discountAmount2).isEqualTo(1 * WEEKDAY_DISCOUNT_AMOUNT);
        assertThat(discountAmount3).isEqualTo(5 * WEEKDAY_DISCOUNT_AMOUNT);
    }
}