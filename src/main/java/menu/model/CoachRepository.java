package menu.model;

import java.util.ArrayList;
import java.util.List;

public class CoachRepository {
    private static List<Coach> coaches;

    public CoachRepository() {
        coaches = new ArrayList<>();
    }

    public void save(Coach coach) {
        coaches.add(coach);
    }
}
