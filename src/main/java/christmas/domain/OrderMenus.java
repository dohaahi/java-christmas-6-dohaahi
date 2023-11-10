package christmas.domain;

import static christmas.util.StringConverter.delimiterStringToList;
import static christmas.validator.OrderMenusValidator.validateInputOrderMenus;

import java.util.ArrayList;
import java.util.List;

public class OrderMenus {
    public static final String DELIMITER = ", ";
    private final List<OrderMenu> menus;

    public OrderMenus(final String input) {
        validateInputOrderMenus(input);

        List<String> orderMenus = delimiterStringToList(DELIMITER, input);
        List<OrderMenu> menus = converterStringToMenus(orderMenus);

        this.menus = menus;
    }

    private List<OrderMenu> converterStringToMenus(List<String> orderMenus) {
        List<OrderMenu> menus = new ArrayList<>();

        orderMenus.forEach(orderMenu -> {
            OrderMenu menu = OrderMenu.from(orderMenu);
            menus.add(menu);
        });
        return menus;
    }
}