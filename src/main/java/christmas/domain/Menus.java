package christmas.domain;

import static christmas.util.StringConverter.delimiterStringToList;
import static christmas.validator.OrderMenusValidator.validateOrderMenus;

import java.util.ArrayList;
import java.util.List;

public class Menus {
    public static final String DELIMITER = ", ";
    private final List<Menu> menus;

    public Menus(final String input) {
        List<String> orderMenus = delimiterStringToList(DELIMITER, input);
        List<Menu> menus = converterStringToMenus(orderMenus);
        validateOrderMenus(menus);

        this.menus = menus;
    }

    private List<Menu> converterStringToMenus(List<String> orderMenus) {
        List<Menu> menus = new ArrayList<>();

        orderMenus.forEach(orderMenu -> {
            Menu menu = Menu.from(orderMenu);
            menus.add(menu);
        });

        return menus;
    }

    public List<Menu> getMenus() {
        return List.copyOf(menus);
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        return totalPrice;
    }
}