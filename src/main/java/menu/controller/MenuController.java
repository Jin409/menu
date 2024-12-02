package menu.controller;

import java.util.List;
import java.util.function.Supplier;
import menu.handler.ErrorHandler;
import menu.handler.InputHandler;
import menu.model.Coach;
import menu.service.CoachService;
import menu.view.OutputView;

public class MenuController {
    private final CoachService coachService;

    public MenuController(CoachService coachService) {
        this.coachService = coachService;
    }

    public void run() {
        OutputView.displayStartMessage();
        List<Coach> coaches = retryOnInvalidInput(this::getCoaches);
        coaches.forEach(coachService::save);
    }

    private List<Coach> getCoaches() {
        List<String> coachNames = InputHandler.getCoachNames();
        return coachService.validateCoaches(coachNames);
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
