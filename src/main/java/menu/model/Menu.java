package menu.model;

import java.util.List;

public enum Menu {
    JAPANESE_FOODS(Category.JAPANESE, Food.getFoodNamesByCategory(Category.JAPANESE)),
    KOREAN_FOODS(Category.KOREAN, Food.getFoodNamesByCategory(Category.KOREAN)),
    CHINESE_FOODS(Category.CHINESE, Food.getFoodNamesByCategory(Category.CHINESE)),
    ASIAN_FOODS(Category.ASIAN, Food.getFoodNamesByCategory(Category.ASIAN)),
    WESTERN_FOODS(Category.WESTERN, Food.getFoodNamesByCategory(Category.WESTERN));

    private final Category category;
    private final List<String> foods;

    Menu(Category category, List<String> foods) {
        this.category = category;
        this.foods = foods;
    }

    public static List<String> getFoodNamesByCategory(Category category) {
        for (Menu menu : values()) {
            if (menu.category.equals(category)) {
                return menu.foods;
            }
        }
        throw new IllegalArgumentException("해당 카테고리의 메뉴는 존재하지 않습니다.");
    }
}