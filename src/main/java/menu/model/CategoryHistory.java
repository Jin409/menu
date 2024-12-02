package menu.model;

public class CategoryHistory {
    private final Category category;

    public CategoryHistory(Category category) {
        this.category = category;
    }

    public boolean hasCategory(Category comparedCategory) {
        return this.category == comparedCategory;
    }
}
