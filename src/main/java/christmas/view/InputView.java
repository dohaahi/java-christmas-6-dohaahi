package christmas.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static christmas.domain.Date.CURRENT_MONTH;
import static christmas.domain.MenuItems.DELIMITER;
import static christmas.util.FunctionalInterfaces.retryIfFailure;
import static christmas.util.StringConverter.delimiterStringToList;
import static christmas.validator.DateValidator.validateInputDate;
import static christmas.validator.MenusValidator.validateInputOrderMenus;

import christmas.domain.Date;
import christmas.domain.MenuItem;
import christmas.domain.MenuItems;
import christmas.domain.order.Order;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static final String GREETING_MESSAGE = "안녕하세요! 우테코 식당 " + CURRENT_MONTH + "월 이벤트 플래너입니다.\n";
    public static final String EXPECTED_VISIT_DATE_MESSAGE = CURRENT_MONTH + "월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)\n";
    public static final String ORDER_MENU_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)\n";

    public Order readOrder() {
        System.out.println(GREETING_MESSAGE);

        Date date = retryIfFailure(this::readVisitDate);
        MenuItems menus = retryIfFailure(this::readOrderMenus);
        return new Order(date, menus);
    }

    private Date readVisitDate() {
        System.out.println(EXPECTED_VISIT_DATE_MESSAGE);
        final String input = readLine().trim();
        validateInputDate(input);

        return new Date(Integer.parseInt(input));
    }

    private MenuItems readOrderMenus() {
        System.out.println(ORDER_MENU_MESSAGE);
        final String input = readLine().trim();
        validateInputOrderMenus(input);

        List<String> orderMenus = delimiterStringToList(DELIMITER, input);
        List<MenuItem> menuItems = retryIfFailure(() -> converterStringToMenu(orderMenus));

        return new MenuItems(menuItems);
    }

    private List<MenuItem> converterStringToMenu(List<String> orderMenus) {
        List<MenuItem> menuItems = new ArrayList<>();

        orderMenus.forEach(orderMenu -> {
            MenuItem menuItem = MenuItem.from(orderMenu);
            menuItems.add(menuItem);
        });

        return menuItems;
    }
}