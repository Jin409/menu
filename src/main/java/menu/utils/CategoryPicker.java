package menu.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import menu.model.Category;
import menu.model.CategoryHistory;

public class CategoryPicker {
    private static final int ALLOWED_DUPLICATED_COUNT_FOR_CATEGORY = 2;

    public static Category pickCategory(List<CategoryHistory> categoryHistories) {
        while (true) {
            int randomNumber = Randoms.pickNumberInRange(1, 5);
            Category category = Category.findByOrder(randomNumber);

            if (isValidCategory(categoryHistories, category)) {
                return category;
            }
        }
    }

    private static boolean isValidCategory(List<CategoryHistory> categoryHistories, Category category) {
        int duplicatedCount = 0;

        for (CategoryHistory history : categoryHistories) {
            if (history.hasCategory(category)) {
                duplicatedCount++;
            }
        }
        return duplicatedCount < ALLOWED_DUPLICATED_COUNT_FOR_CATEGORY;
    }
}
