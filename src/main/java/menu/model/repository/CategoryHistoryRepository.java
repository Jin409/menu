package menu.model.repository;

import java.util.ArrayList;
import java.util.List;
import menu.model.CategoryHistory;
import menu.model.Day;

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

    public CategoryHistory findByDay(Day day) {
        return categoryHistoryList.stream()
                .filter(history -> history.recordedAt(day))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("해당 요일에 속하는 기록이 없습니다."));

    }
}

