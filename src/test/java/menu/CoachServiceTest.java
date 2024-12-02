package menu;

import java.util.List;
import menu.config.AppConfig;
import menu.service.CoachService;
import menu.view.validator.InputValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CoachServiceTest {
    private final CoachService coachService;

    public CoachServiceTest() {
        this.coachService = new AppConfig().coachService();
    }

    @Test
    void 코치들이_너무_많으면_예외를_던진다() {
        // given
        List<String> invalidInput = List.of("한명", "두명", "세명", "네명", "다섯명", "여섯명");

        // when & then
        assertThatThrownBy(() -> coachService.validateCoaches(invalidInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 코치들이_너무_적으면_예외를_던진다() {
        // given
        List<String> invalidInput = List.of("한명");

        // when & then
        assertThatThrownBy(() -> coachService.validateCoaches(invalidInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
