package menu.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import menu.model.Category;
import menu.model.Coach;
import menu.model.Food;
import menu.model.FoodHistory;
import menu.model.Menu;

public class FoodPicker {
    public static Food pickFood(List<FoodHistory> histories, Coach coach, Category category) {
        List<String> foodNames = Menu.getFoodNamesByCategory(category);

        while (true) {
            String foodName = Randoms.shuffle(foodNames).get(0);
            Food food = Food.findByName(foodName);

            if (isValidFood(histories, coach, food)) {
                return food;
            }
        }
    }

    private static boolean isValidFood(List<FoodHistory> histories, Coach coach, Food food) {
        if (coach.isAllergicTo(food)) {
            return false;
        }

        for (FoodHistory history : histories) {
            if (history.hasAlreadyEaten(food)) {
                return false;
            }
        }
        return true;
    }
}
