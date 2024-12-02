package menu.model.repository;

import java.util.ArrayList;
import java.util.List;
import menu.model.Coach;

public class CoachRepository {
    private static List<Coach> coaches;

    public CoachRepository() {
        coaches = new ArrayList<>();
    }

    public void save(Coach coach) {
        coaches.add(coach);
    }

    public List<Coach> getAllCoaches() {
        return coaches;
    }
}
