package menu.model;

import java.util.Arrays;

public enum Category {
    JAPANESE("일식", 1), KOREAN("한식", 2), CHINESE("중식", 3), ASIAN("아시안", 4), WESTERN("양식", 5);

    private final String name;
    private final int order;

    Category(String name, int order) {
        this.name = name;
        this.order = order;
    }

    public static Category findByOrder(int order) {
        return Arrays.stream(Category.values()).filter(c -> c.order == order).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카테고리입니다."));
    }
}
