package menu.service;

import java.util.List;
import java.util.stream.Collectors;
import menu.model.Category;
import menu.model.CategoryHistory;
import menu.model.Day;
import menu.model.repository.CategoryHistoryRepository;
import menu.model.Coach;
import menu.model.repository.CoachRepository;
import menu.model.Food;
import menu.model.FoodHistory;
import menu.model.repository.FoodHistoryRepository;
import menu.utils.CategoryPicker;
import menu.utils.FoodPicker;

public class FoodService {
    private static final int MAX_RANGE_VALID_ALLERGIC_FOOD_SIZE = 2;

    private final CategoryHistoryRepository categoryHistoryRepository;
    private final FoodHistoryRepository foodHistoryRepository;
    private final CoachRepository coachRepository;

    public FoodService(CategoryHistoryRepository categoryHistoryRepository, FoodHistoryRepository foodHistoryRepository,
                       CoachRepository coachRepository) {
        this.categoryHistoryRepository = categoryHistoryRepository;
        this.foodHistoryRepository = foodHistoryRepository;
        this.coachRepository = coachRepository;
    }

    public List<Food> getAllergicFoods(List<String> foodNames) {
        if (foodNames.size() > MAX_RANGE_VALID_ALLERGIC_FOOD_SIZE) {
            throw new IllegalArgumentException("못 먹는 음식은 최대 2개까지 입력 가능합니다.");
        }

        return foodNames.stream().map(Food::findByName).collect(Collectors.toList());
    }

    public void pickFoods() {
        for (Day day : Day.values()) {
            Category category = pickCategory(day);
            pickFoodForAllCoaches(category);
        }
    }

    private Category pickCategory(Day day) {
        Category category = CategoryPicker.pickCategory(categoryHistoryRepository.getAll());
        categoryHistoryRepository.save(new CategoryHistory(day, category));
        return category;
    }

    private void pickFoodForAllCoaches(Category category) {
        List<Coach> coaches = coachRepository.getAllCoaches();
        for (Coach coach : coaches) {
            List<FoodHistory> foodHistories = foodHistoryRepository.getFoodHistoriesOf(coach);
            Food food = FoodPicker.pickFood(foodHistories, coach, category);
            foodHistoryRepository.save(new FoodHistory(coach, food));
        }
    }
}
