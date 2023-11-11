package christmas.validator;

import static christmas.domain.Menus.MIN_ORDER_COUNT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.domain.Menus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuValidatorTest {
    @DisplayName("주문한 메뉴 개수가 " + MIN_ORDER_COUNT + "개 미만인 경우 예외 발생")
    @Test
    void Order_Count_Under_Min() {
        // given
        String menus1 = "시저샐러드-0";
        String menus2 = "양송이수프--1, 크리스마스파스타-3, 제로콜라-1";

        // when
        // then
        assertThatThrownBy(() -> new Menus(menus1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_INPUT_ORDER_MENU_MESSAGE.getMessage());
         assertThatThrownBy(() -> new Menus(menus2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_INPUT_ORDER_MENU_MESSAGE.getMessage());
    }

    @DisplayName("메뉴 목록에 존재하는 메뉴를 시키면 검증 통과")
    @Test
    void Order_Menu_In_Menu_Item() {
        // given
        String menus1 = "양송이수프-1";
        String menus2 = "양송이수프-1, 크리스마스파스타-3, 제로콜라-1";

        // when
        // then
        new Menus(menus1);
        new Menus(menus2);
    }

    @DisplayName("메뉴 목록에 존재하지 않는 메뉴를 시키면 예외 발생")
    @Test
    void Order_Menu_Not_In_Menu_Item() {
        // given
        String menus1 = "브로콜리수프-1";
        String menus2 = "브로콜리수프-1, 윈터파스타-3, 아메리카노-1";

        // when
        // then
        assertThatThrownBy(() -> new Menus(menus1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_INPUT_ORDER_MENU_MESSAGE.getMessage());
        assertThatThrownBy(() -> new Menus(menus2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_INPUT_ORDER_MENU_MESSAGE.getMessage());
    }
}