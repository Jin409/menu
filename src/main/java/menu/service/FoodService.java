package menu.service;

import java.util.List;
import java.util.stream.Collectors;
import menu.model.Food;

public class FoodService {

    private static final int MIN_RANGE_VALID_ALLERGIC_FOOD_SIZE = 0;
    private static final int MAX_RANGE_VALID_ALLERGIC_FOOD_SIZE = 2;

    public List<Food> getAllergicFoods(List<String> foodNames) {
        if (foodNames.size() < MIN_RANGE_VALID_ALLERGIC_FOOD_SIZE
                || foodNames.size() > MAX_RANGE_VALID_ALLERGIC_FOOD_SIZE) {
            throw new IllegalArgumentException("못 먹는 음식은 최대 2개까지 입력 가능합니다.");
        }

        return foodNames.stream().map(Food::findByName).collect(Collectors.toList());
    }
}
