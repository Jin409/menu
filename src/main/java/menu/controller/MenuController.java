package menu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import menu.handler.ErrorHandler;
import menu.handler.InputHandler;
import menu.model.Category;
import menu.model.Coach;
import menu.model.Food;
import menu.service.CoachService;
import menu.service.FoodService;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final CoachService coachService;
    private final FoodService foodService;

    public MenuController(CoachService coachService, FoodService foodService) {
        this.coachService = coachService;
        this.foodService = foodService;
    }

    public void run() {
        OutputView.displayStartMessage();
        readyToPick();
    }

    private void getResult() {
        foodService.pickFoods();
    }

    private void readyToPick() {
        List<String> coachNames = retryOnInvalidInput(this::getValidCoachNames);

        for (String name : coachNames) {
            InputView.displayMessageToAllergicFoods(name);
            List<Food> allergicFoods = retryOnInvalidInput(this::getAllergicFoods);
            Coach coach = new Coach(name, allergicFoods);
            coachService.save(coach);
        }
    }

    private List<Food> getAllergicFoods() {
        List<String> foodNames = InputHandler.getAllergicFoods();
        if (foodNames.isEmpty()) {
            return new ArrayList<>();
        }
        return foodService.getAllergicFoods(foodNames);
    }


    private List<String> getValidCoachNames() {
        List<String> coachNames = InputHandler.getCoachNames();
        coachService.validateCoaches(coachNames);
        return coachNames;
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
