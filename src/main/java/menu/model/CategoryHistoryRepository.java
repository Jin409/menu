package menu.model;

import java.util.ArrayList;
import java.util.List;
import menu.utils.CategoryPicker;

public class CategoryHistoryRepository {
    private static List<CategoryHistory> categoryHistoryList;

    public CategoryHistoryRepository() {
        this.categoryHistoryList = new ArrayList<>();
    }

    public void save(CategoryHistory categoryHistory) {
        categoryHistoryList.add(categoryHistory);
    }

    public List<CategoryHistory> getAll() {
        return categoryHistoryList;
    }
}

