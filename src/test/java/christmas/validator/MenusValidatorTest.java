package christmas.validator;

import static christmas.validator.OrderMenusValidator.validateInputOrderMenus;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.domain.Menus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class MenusValidatorTest {
    @Nested
    @DisplayName("validateInputOrderMenu 메소드 test")
    class ValidateInputOrderMenuTest {
        @DisplayName("빈 값이 입력되면 예외 발생")
        @Test
        void Value_Is_Empty() {
            // given
            String input = "";

            // when
            // then
            assertThatThrownBy(() -> validateInputOrderMenus(input)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.ENTER_VALUE_MASSAGE.getMessage());
        }

        @DisplayName(Menus.DELIMITER + "를 사용하여 메뉴형식을 올바르게 입력하면 검증 통과")
        @Test
        void Input_Valid_Menu_Format() {
            // given
            String input1 = "시저샐러드-1";
            String input2 = "시저샐러드-1, 티본스테이크-1, 크리스마스파스타-1, 제로콜라-3, 아이스크림-1";

            // when
            // then
            validateInputOrderMenus(input1);
            validateInputOrderMenus(input2);
        }

        @DisplayName(Menus.DELIMITER + "외에 다른 구분자를 사용하여 메뉴를 입력하면 예외 발생")
        @Test
        void Invalid_Input_Menu_Delimiter() {
            // given
            String input1 = "시저샐러드-1; 티본스테이크-1; 크리스마1스파스타-1; 제로콜라-3, 아이스크림-1"; // 구분자: ;
            String input2 = "시저샐러드-1. 티본스테이크-1. 크리스마1스파스타-1. 제로콜라-3, 아이스크림-1"; // 구분자: .

            // when
            // then
            assertThatThrownBy(() -> validateInputOrderMenus(input1)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_INPUT_ORDER_MENU_MESSAGE.getMessage());
            assertThatThrownBy(() -> validateInputOrderMenus(input2)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_INPUT_ORDER_MENU_MESSAGE.getMessage());
        }

        @DisplayName("구분자 사이에 공백이 있는 경우 예외 발생")
        @Test
        void Invalid_Delimiter_With_Spaces() {
            // given
            String input1 = "시저샐러드 - 1";
            String input2 = "시저샐러드 - 1, 티본스테이크 - 1, 크리스마스파스타 - 1, 제로콜라 - 3, 아이스크림 - 1";

            // when
            // then
            assertThatThrownBy(() -> validateInputOrderMenus(input1)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_INPUT_ORDER_MENU_MESSAGE.getMessage());
            assertThatThrownBy(() -> validateInputOrderMenus(input2)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_INPUT_ORDER_MENU_MESSAGE.getMessage());
        }
    }

    @Nested
    @DisplayName("validateOrderMenus 메소드 test")
    class ValidateOrderMenusTest {
        @DisplayName("메뉴 목록에 존재하는 메뉴를 시키면 검증 통과")
        @Test
        void test() {
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
        void test2() {
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

        @DisplayName("중복되는 메뉴를 시키면 예외 발생")
        @Test
        void test3() {
            // given
            String menus1 = "양송이수프-1, 양송이수프-4";
            String menus2 = "양송이수프-1, 크리스마스파스타-3, 제로콜라-1, 크리스마스파스타-2";

            // when
            // then
            assertThatThrownBy(() -> new Menus(menus1))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_INPUT_ORDER_MENU_MESSAGE.getMessage());
            assertThatThrownBy(() -> new Menus(menus2))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_INPUT_ORDER_MENU_MESSAGE.getMessage());
        }

        @DisplayName("음료만 주문하는 경우 예외 발생")
        @Test
        void test4() {
            // given
            String menus1 = "제로콜라-1";
            String menus2 = "제로콜라-1, 레드와인-3, 샴페인-1";

            // when
            // then
            assertThatThrownBy(() -> new Menus(menus1))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.DO_NOT_JUST_ORDER_DRINK_MESSAGE.getMessage());
            assertThatThrownBy(() -> new Menus(menus2))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.DO_NOT_JUST_ORDER_DRINK_MESSAGE.getMessage());
        }

        @DisplayName("주문 개수가 20개 이하인 경우 검증 통과")
        @Test
        void Order_Count_Under_Max() {
            // given
            String menus = "시저샐러드-10, 티본스테이크-9, 크리스마스파스타-1"; // 총 20개 주문

            // when
            // then
            new Menus(menus);
        }

        @DisplayName("주문 개수가 20개 초과된 경우 예외 발생")
        @Test
        void Order_Count_Exceeds_Max() {
            // given
            String menus = "시저샐러드-10, 티본스테이크-10, 크리스마스파스타-1"; // 총 21개 주문

            // when
            // then
            assertThatThrownBy(() -> new Menus(menus))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_INPUT_ORDER_MENU_COUNT_MESSAGE.getMessage());
        }
    }
}
