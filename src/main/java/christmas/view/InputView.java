package christmas.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static christmas.validator.DateValidator.validateInputDate;

import christmas.domain.dto.DateDto;

public class InputView {
    private static final String GREETING_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.\n";
    private static final String EXPECTED_VISIT_DATE_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)\n";
    private static final String ORDER_MENU_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)\n";

    public DateDto inputVisitDate() {
        System.out.println(GREETING_MESSAGE);
        System.out.println(EXPECTED_VISIT_DATE_MESSAGE);
        final String input = readLine().trim();
        validateInputDate(input);

        return new DateDto(Integer.parseInt(input));
    }
}