package christmas.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static christmas.validator.DateValidator.validateInputDate;

import christmas.domain.Date;
import christmas.domain.dto.OrderMenuDto;
import christmas.domain.dto.OrderMenusDto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public static final String GREETING_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.\n";
    public static final String EXPECTED_VISIT_DATE_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)\n";
    public static final String ORDER_MENU_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)\n";

    public Date inputVisitDate() {
        System.out.println(GREETING_MESSAGE);
        System.out.println(EXPECTED_VISIT_DATE_MESSAGE);
        final String input = readLine().trim();
        validateInputDate(input);

        return new Date(Integer.parseInt(input));
    }
}