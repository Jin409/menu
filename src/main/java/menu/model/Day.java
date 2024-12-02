package menu.model;

public enum Day {
    MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5);

    private final int order;

    Day(int order) {
        this.order = order;
    }
}
