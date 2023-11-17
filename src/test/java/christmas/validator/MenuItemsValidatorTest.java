package christmas.validator;

import static christmas.domain.menu.MenuItems.MAX_ORDER_COUNT;
import static christmas.validator.MenusValidator.validateInputOrderMenus;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.domain.menu.MenuItem;
import christmas.domain.menu.MenuItems;
import christmas.exception.IllegalMenuException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class MenuItemsValidatorTest {
    @Nested
    @DisplayName("validateInputOrderMenu 메소드 test")
    class ValidateInputOrderMenuTestItemItems {
        @DisplayName("빈 값이 입력되면 예외 발생")
        @Test
        void Value_Is_Empty() {
            // given
            String input = "";

            // when
            // then
            assertThatThrownBy(() -> validateInputOrderMenus(input))
                    .isInstanceOf(IllegalMenuException.class);
        }

        @DisplayName(MenuItems.DELIMITER + "를 사용하여 메뉴형식을 올바르게 입력하면 검증 통과")
        @Test
        void Input_Valid_Menu_Format() {
            // given
            String input1 = "시저샐러드-1";
            String input2 = "시저샐러드-1,티본스테이크-1,크리스마스파스타-1,제로콜라-3,아이스크림-1";

            // when
            // then
            validateInputOrderMenus(input1);
            validateInputOrderMenus(input2);
        }

        @DisplayName(MenuItems.DELIMITER + "외에 다른 구분자를 사용하여 메뉴를 입력하면 예외 발생")
        @Test
        void Invalid_Input_Menu_Delimiter() {
            // given
            String input1 = "시저샐러드-1; 티본스테이크-1; 크리스마1스파스타-1; 제로콜라-3; 아이스크림-1"; // 구분자: ;
            String input2 = "시저샐러드-1. 티본스테이크-1. 크리스마1스파스타-1. 제로콜라-3. 아이스크림-1"; // 구분자: .

            // when
            // then
            assertThatThrownBy(() -> validateInputOrderMenus(input1))
                    .isInstanceOf(IllegalMenuException.class);
            assertThatThrownBy(() -> validateInputOrderMenus(input2))
                    .isInstanceOf(IllegalMenuException.class);
        }

        @DisplayName("구분자 사이에 공백이 있는 경우 예외 발생")
        @Test
        void Invalid_Delimiter_With_Spaces() {
            // given
            String input1 = "시저샐러드 - 1";
            String input2 = "시저샐러드 - 1, 티본스테이크 - 1, 크리스마스파스타 - 1, 제로콜라 - 3, 아이스크림 - 1";

            // when
            // then
            assertThatThrownBy(() -> validateInputOrderMenus(input1))
                    .isInstanceOf(IllegalMenuException.class);
            assertThatThrownBy(() -> validateInputOrderMenus(input2))
                    .isInstanceOf(IllegalMenuException.class);
        }
    }

    @Nested
    @DisplayName("validateOrderMenus 메소드 test")
    class ValidateOrderMenuTestItems {
        MenuItem salad, soup, steak, pasta, cola, wine;

        @BeforeEach
        void beforeEach() {
            salad = MenuItem.from("시저샐러드-10");
            soup = MenuItem.from("양송이수프-9");
            steak = MenuItem.from("티본스테이크-1");
            pasta = MenuItem.from("크리스마스파스타-1");
            cola = MenuItem.from("제로콜라-1");
            wine = MenuItem.from("레드와인-1");
        }

        @DisplayName("중복되는 메뉴를 시키면 예외 발생")
        @Test
        void Duplicate_Menu_Order() {
            // given
            List<MenuItem> menus1 = List.of(soup, soup);
            List<MenuItem> menus2 = List.of(soup, pasta, cola, pasta);

            // when
            // then
            assertThatThrownBy(() -> new MenuItems(menus1))
                    .isInstanceOf(IllegalMenuException.class);
            assertThatThrownBy(() -> new MenuItems(menus2))
                    .isInstanceOf(IllegalMenuException.class);
        }

        @DisplayName("음료만 주문하는 경우 예외 발생")
        @Test
        void Order_Only_Drink() {
            // given
            List<MenuItem> menus1 = List.of(cola);
            List<MenuItem> menus2 = List.of(cola, wine);

            // when
            // then
            assertThatThrownBy(() -> new MenuItems(menus1))
                    .isInstanceOf(IllegalMenuException.class);
            assertThatThrownBy(() -> new MenuItems(menus2))
                    .isInstanceOf(IllegalMenuException.class);
        }

        @DisplayName("주문 개수가 +" + MAX_ORDER_COUNT + "개 이하인 경우 검증 통과")
        @Test
        void Order_Count_Under_Max() {
            // given
            List<MenuItem> menus = List.of(salad, soup, cola); // 10, 9, 1 -> 총 20개 주문

            // when
            // then
            new MenuItems(menus);
        }

        @DisplayName("주문 개수가 " + MAX_ORDER_COUNT + "개 초과된 경우 예외 발생")
        @Test
        void Order_Count_Exceeds_Max() {
            // given
            List<MenuItem> menus = List.of(salad, steak, cola, soup); // 총 21개 주문

            // when
            // then
            assertThatThrownBy(() -> new MenuItems(menus))
                    .isInstanceOf(IllegalMenuException.class);
        }
    }
}