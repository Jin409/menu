package menu.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
}
