package menu.handler;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import menu.view.InputView;
import menu.view.validator.InputValidator;

public class InputHandler {
    private static final String DELIMITER = ",";

    public static List<String> getCoachNames() {
        String rawInput = InputView.readCoachNames();
        InputValidator.validateCoachNames(rawInput);
        return Arrays.asList(rawInput.split(DELIMITER));
    }

    public static List<String> getAllergicFoods() {
        String rawInput = InputView.readAllergicFoods();

        if (rawInput.isBlank()) {
            return List.of();
        }

        InputValidator.validateAllergicFoods(rawInput);
        return Arrays.asList(rawInput.split(DELIMITER));
    }
}
