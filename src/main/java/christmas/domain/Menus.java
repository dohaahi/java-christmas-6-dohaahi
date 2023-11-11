package christmas.domain;

import static christmas.util.StringConverter.delimiterStringToList;
import static christmas.validator.MenusValidator.validateOrderMenus;

import christmas.domain.menu.MenuItem;
import christmas.validator.ErrorMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Menus {
    public static final String DELIMITER = ", ";
    public static final int MIN_ORDER_COUNT = 1;
    public static final int MAX_ORDER_COUNT = 20;
    private final Map<MenuItem, Integer> menus;

    public Menus(final String input) {
        List<String> orderMenus = delimiterStringToList(DELIMITER, input);
        List<Menu> menus = converterStringToMenus(orderMenus);
        validateOrderMenus(menus);

        Map<MenuItem, Integer> menuStorage = new HashMap<>();
        menus.forEach(menu -> {
            menuStorage.put(MenuItem.getMenuItem(menu), menu.getMenuCount());
        });

        this.menus = menuStorage;
    }

    private List<Menu> converterStringToMenus(List<String> orderMenus) {
        List<Menu> menus = new ArrayList<>();

        try {
            orderMenus.forEach(orderMenu -> {
                Menu menu = Menu.from(orderMenu);
                menus.add(menu);
            });
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_ORDER_MENU_MESSAGE.getMessage());
        }

        return menus;
    }

    public int getTotalPrice() {
        int totalPrice = 0;

        for (Entry<MenuItem, Integer> menu : menus.entrySet()) {
            totalPrice += menu.getKey().getMenuPrice() * menu.getValue();
        }

        return totalPrice;
    }

    public Map<MenuItem, Integer> getMenus() {
        return Map.copyOf(menus);
    }
}