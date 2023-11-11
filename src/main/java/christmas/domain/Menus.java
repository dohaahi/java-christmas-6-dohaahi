package christmas.domain;

import static christmas.util.StringConverter.delimiterStringToList;
import static christmas.validator.MenusValidator.validateOrderMenus;

import christmas.domain.menu.MenuItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Menus {
    public static final String DELIMITER = ", ";
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

        orderMenus.forEach(orderMenu -> {
            Menu menu = Menu.from(orderMenu);
            menus.add(menu);
        });

        return menus;
    }

    public int getTotalPrice() {
        int totalPrice = 0;

        for (Entry<MenuItem, Integer> menu : menus.entrySet()) {
            totalPrice += menu.getKey().getMenuPrice() * menu.getValue();
        }

        return totalPrice;
    }
}