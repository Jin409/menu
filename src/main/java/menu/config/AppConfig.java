package menu.config;

import menu.controller.MenuController;
import menu.model.FoodHistory;
import menu.model.repository.CategoryHistoryRepository;
import menu.model.repository.CoachRepository;
import menu.model.repository.FoodHistoryRepository;
import menu.service.CoachService;
import menu.service.FoodService;

public class AppConfig {

    private CoachRepository coachRepository() {
        return new CoachRepository();
    }

    private CategoryHistoryRepository categoryHistoryRepository() {
        return new CategoryHistoryRepository();
    }

    private FoodHistoryRepository foodHistoryRepository() {
        return new FoodHistoryRepository();
    }

    private CoachService coachService() {
        return new CoachService(coachRepository());
    }

    private FoodService foodService() {
        return new FoodService(categoryHistoryRepository(), foodHistoryRepository(), coachRepository());
    }

    public MenuController menuController() {
        return new MenuController(coachService(), foodService());
    }
}
