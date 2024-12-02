package menu.model;

public enum Day {
    월요일(1), 화요일(2), 수요일(3), 목요일(4), 금요일(5);

    private final int order;

    Day(int order) {
        this.order = order;
    }
}
