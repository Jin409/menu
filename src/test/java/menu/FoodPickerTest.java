package menu;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;
import menu.model.Category;
import menu.model.Coach;
import menu.model.Day;
import menu.model.Food;
import menu.model.FoodHistory;
import menu.utils.FoodPicker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FoodPickerTest {
    @Test
    void 중복된_메뉴와_못_먹는_메뉴를_선정하지_않는지_확인헤라() {
        // given
        Coach coach = new Coach("코치", List.of(Food.규동));
        List<FoodHistory> histories = List.of(new FoodHistory(coach, Food.가츠동, Day.월요일));
        Category category = Category.JAPANESE;

        // when & then
        for (int i = 0; i < 1_000; i++) {
            Food food = FoodPicker.pickFood(histories, coach, category);
            assertAll(
                    () -> assertNotEquals(food, Food.가츠동),
                    () -> assertNotEquals(food, Food.규동)
            );
        }
    }
}
