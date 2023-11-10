package christmas.domain.util;

import java.util.Arrays;
import java.util.List;

public class StringConvertor {
    public static final List<String> delimiterStringToList(final String delimiter, final String input) {
        return Arrays.stream(input.split(delimiter)).toList();
    }
}
