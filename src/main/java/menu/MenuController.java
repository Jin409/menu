package menu;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import menu.handler.ErrorHandler;
import menu.handler.InputHandler;
import menu.model.Coach;
import menu.model.Coaches;
import menu.view.OutputView;

public class MenuController {
    public void run() {
        OutputView.displayStartMessage();
        Coaches coaches = retryOnInvalidInput(this::getCoaches);
    }

    private Coaches getCoaches() {
        List<String> coachNames = InputHandler.getCoachNames();
        List<Coach> coaches = coachNames.stream()
                .map(Coach::new)
                .collect(Collectors.toList());
        return new Coaches(coaches);
    }

    private <T> T retryOnInvalidInput(Supplier<T> inputSupplier) {
        while (true) {
            try {
                return inputSupplier.get();
            } catch (IllegalArgumentException e) {
                ErrorHandler.handle(e);
            }
        }
    }
}
