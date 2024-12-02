package menu.model;

import java.util.List;

public class Coach {

    private static final int MIN_RANGE_NAME_LENGTH = 2;
    private static final int MAX_RANGE_NAME_LENGTH = 4;

    private final String name;
    private final List<Food> allergicFoods;

    public Coach(String name, List<Food> allergicFoods) {
        this.name = name;
        this.allergicFoods = allergicFoods;
    }

    public static void validate(final String name) {
        if (name.length() > MAX_RANGE_NAME_LENGTH || name.length() < MIN_RANGE_NAME_LENGTH) {
            throw new IllegalArgumentException("코치의 이름은 2글자에서 4글자 사이여야 합니다.");
        }
    }

    public boolean isAllergicTo(Food food) {
        return allergicFoods.contains(food);
    }
}
