package menu.model.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.model.Coach;
import menu.model.Day;
import menu.model.FoodHistory;

public class FoodHistoryRepository {
    private static List<FoodHistory> foodHistories;

    public FoodHistoryRepository() {
        foodHistories = new ArrayList<>();
    }

    public void save(FoodHistory foodHistory) {
        foodHistories.add(foodHistory);
    }

    public List<FoodHistory> getFoodHistoriesOf(Coach coach) {
        return foodHistories.stream()
                .filter(history -> history.belongsTo(coach))
                .collect(Collectors.toList());
    }

    public List<FoodHistory> findByDay(Day day) {
        return foodHistories.stream()
                .filter(history -> history.recordedAt(day))
                .collect(Collectors.toList());
    }
}
