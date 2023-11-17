package christmas.domain.promotion;

import static christmas.domain.promotion.ChristmasPromotion.DAILY_DISCOUNT_AMOUNT;
import static christmas.domain.promotion.ChristmasPromotion.DISCOUNT_AMOUNT_INIT;
import static christmas.domain.promotion.Promotion.NO_DISCOUNT;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.date.Date;
import christmas.domain.menu.MenuItem;
import christmas.domain.menu.MenuItems;
import christmas.domain.order.OrderElement;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChristmasPromotionTest {
    MenuItems menuItems;
    ChristmasPromotion christmasPromotion;

    @BeforeEach
    void beforeEach() {
        menuItems = new MenuItems(List.of(MenuItem.from("양송이수프-10")));
        christmasPromotion = new ChristmasPromotion();
    }

    @DisplayName("크리스마스가 지나기 전에 방문한 경우 할인 금액을 구할 수 있다.")
    @Test
    void Non_Passed_Christmas() {
        // given
        Date date = new Date(25);
        OrderElement orderElement = new OrderElement(date, menuItems);

        // when
        int discountAmount = christmasPromotion.discountAmount(orderElement);

        // then
        assertThat(discountAmount).isEqualTo(DISCOUNT_AMOUNT_INIT + (DAILY_DISCOUNT_AMOUNT * (date.getDay() - 1)));
    }

    @DisplayName("크리스마스가 지나고 방문한 경우 할인은 없다.")
    @Test
    void Passed_Christmas() {
        // given
        Date date = new Date(26);
        OrderElement orderElement = new OrderElement(date, menuItems);

        // when
        int discountAmount = christmasPromotion.discountAmount(orderElement);

        // then
        assertThat(discountAmount).isEqualTo(NO_DISCOUNT);
    }
}