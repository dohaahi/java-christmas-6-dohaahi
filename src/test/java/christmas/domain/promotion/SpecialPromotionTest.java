package christmas.domain.promotion;

import static christmas.domain.promotion.Promotion.NO_DISCOUNT;
import static christmas.domain.promotion.SpecialPromotion.SPECIAL_DISCOUNT_AMOUNT;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.date.Date;
import christmas.domain.menu.MenuItem;
import christmas.domain.menu.MenuItems;
import christmas.domain.order.OrderElement;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SpecialPromotionTest {
    Date starDay;
    Date nonStarDay;
    MenuItems menu;
    SpecialPromotion specialPromotion;

    @BeforeEach
    void beforeEach() {
        starDay = new Date(25);
        nonStarDay = new Date(26);
        menu = new MenuItems(List.of(MenuItem.from("크리스마스파스타-5")));
        specialPromotion = new SpecialPromotion();
    }

    @DisplayName("달력에 별이 있는 날에 주문을 하면 총 주문 금액에서 " + SPECIAL_DISCOUNT_AMOUNT + "원 만큼 할인해준다.")
    @Test
    void Order_On_Star_Day() {

        // given
        OrderElement orderElement = new OrderElement(starDay, menu);

        // when
        int discountAmount = specialPromotion.discountAmount(orderElement);

        // then
        assertThat(discountAmount).isEqualTo(SPECIAL_DISCOUNT_AMOUNT);
    }

    @DisplayName("달력에 별이 없는 날에 주문을 하면 할인액은 없다.")
    @Test
    void Order_On_Non_Star_Day() {

        // given
        OrderElement orderElement = new OrderElement(nonStarDay, menu);

        // when
        int discountAmount = specialPromotion.discountAmount(orderElement);

        // then
        assertThat(discountAmount).isEqualTo(NO_DISCOUNT);
    }
}