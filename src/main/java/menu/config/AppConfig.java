package menu.config;

import menu.controller.MenuController;
import menu.model.CoachRepository;
import menu.service.CoachService;

public class AppConfig {

    private CoachRepository coachRepository() {
        return new CoachRepository();
    }

    private CoachService coachService() {
        return new CoachService(coachRepository());
    }

    public MenuController menuController() {
        return new MenuController(coachService());
    }
}
