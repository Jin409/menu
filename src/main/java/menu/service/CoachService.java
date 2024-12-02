package menu.service;

import java.util.List;
import java.util.stream.Collectors;
import menu.model.Coach;
import menu.model.CoachRepository;

public class CoachService {

    private static final int MIN_RANGE_VALID_SIZE_OF_COACHES = 2;
    private static final int MAX_RANGE_VALID_SIZE_OF_COACHES = 5;

    private final CoachRepository coachRepository;

    public CoachService(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    public List<Coach> validateCoaches(List<String> coachNames) {
        List<Coach> coaches = coachNames.stream().map(Coach::new).collect(Collectors.toList());
        if (coaches.size() < MIN_RANGE_VALID_SIZE_OF_COACHES || coaches.size() > MAX_RANGE_VALID_SIZE_OF_COACHES) {
            throw new IllegalArgumentException("코치들은 최소 2명에서 최대 5명 사이여야 합니다.");
        }
        return coaches;
    }

    public void save(Coach coach) {
        coachRepository.save(coach);
    }
}
