package menu.config;

import menu.controller.MenuController;
import menu.model.CoachRepository;
import menu.service.CoachService;
import menu.service.FoodService;

public class AppConfig {

    private CoachRepository coachRepository() {
        return new CoachRepository();
    }

    private CoachService coachService() {
        return new CoachService(coachRepository());
    }

    private FoodService foodService() {
        return new FoodService();
    }

    public MenuController menuController() {
        return new MenuController(coachService(), foodService());
    }
}
