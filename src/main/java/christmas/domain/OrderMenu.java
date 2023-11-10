package christmas.domain;

import static christmas.util.StringConverter.delimiterStringToList;
import static christmas.validator.OrderMenusValidator.validateOrderMenus;

import java.util.List;

public class OrderMenu {
    public static final String DELIMITER = "-";
    private final String menuName;
    private final int menuCount;

    private OrderMenu(String orderMenu) {
        List<String> menu = delimiterStringToList(DELIMITER, orderMenu);
        String menuName = menu.get(0);
        int menuCount = Integer.parseInt(menu.get(1));

        this.menuName = menuName;
        this.menuCount = menuCount;
    }

    public static OrderMenu from(final String orderMenu) {
        return new OrderMenu(orderMenu);
    }

    public String getMenuName() {
        return menuName;
    }
}