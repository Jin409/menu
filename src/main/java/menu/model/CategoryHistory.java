package menu.model;

public class CategoryHistory {
    private final Day day;
    private final Category category;

    public CategoryHistory(Day day, Category category) {
        this.day = day;
        this.category = category;
    }

    public boolean hasCategory(Category comparedCategory) {
        return this.category == comparedCategory;
    }
}
