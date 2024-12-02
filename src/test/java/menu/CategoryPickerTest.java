package menu;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import menu.model.Category;
import menu.model.CategoryHistory;
import menu.model.Day;
import menu.utils.CategoryPicker;
import org.junit.jupiter.api.Test;

public class CategoryPickerTest {

    @Test
    void 세번_이상_카테고리가_중복되지_않는지_확인해라() {
        // given
        List<CategoryHistory> categoryHistories = List.of(new CategoryHistory(Day.월요일, Category.ASIAN),
                new CategoryHistory(Day.화요일, Category.ASIAN), new CategoryHistory(Day.수요일, Category.JAPANESE),
                new CategoryHistory(Day.목요일, Category.JAPANESE), new CategoryHistory(Day.목요일, Category.CHINESE),
                new CategoryHistory(Day.목요일, Category.CHINESE), new CategoryHistory(Day.목요일, Category.WESTERN),
                new CategoryHistory(Day.목요일, Category.WESTERN)

        );

        // when & then
        for (int i = 0; i < 100; i++) {
            Category category = CategoryPicker.pickCategory(categoryHistories);
            assertEquals(category, Category.KOREAN);
        }
    }
}
