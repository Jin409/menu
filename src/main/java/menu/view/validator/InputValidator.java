package menu.view.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    private static final String DELIMITER = ",";

    public static void validateCoachNames(String input) {
        if (!input.contains(DELIMITER)) {
            throw new IllegalArgumentException("코치들의 이름은 , 를 포함해야 합니다.");
        }

        List<String> split = Arrays.asList(input.split(DELIMITER));
        Set<String> splitToSet = new HashSet<>(split);

        if (split.size() != splitToSet.size()) {
            throw new IllegalArgumentException("코치들의 이름은 중복되어서는 안됩니다.");
        }
    }

    public static void validateAllergicFoods(String input) {
        if (input.isBlank()) {
            return;
        }

        List<String> split = Arrays.asList(input.split(DELIMITER));
        Set<String> splitToSet = new HashSet<>(split);

        if (split.size() != splitToSet.size()) {
            throw new IllegalArgumentException("못 먹는 메뉴는 중복되어서는 안됩니다.");
        }
    }
}
