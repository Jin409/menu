package menu.model;

import java.util.List;

public class Coaches {
    private static final int MIN_RANGE_VALID_SIZE = 2;
    private static final int MAX_RANGE_VALID_SIZE = 5;

    private final List<Coach> coaches;

    public Coaches(List<Coach> coaches) {
        validate(coaches);
        this.coaches = coaches;
    }

    private void validate(List<Coach> coaches) {
        if (coaches.size() < MIN_RANGE_VALID_SIZE || coaches.size() < MAX_RANGE_VALID_SIZE) {
            throw new IllegalArgumentException("코치들은 2명에서 5명까지 식사를 함께할 수 있습니다.");
        }
    }
}
