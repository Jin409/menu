package menu;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import menu.model.Coach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CoachTest {
    @ParameterizedTest
    @ValueSource(strings = {"다섯글자가넘어가는이름", "한"})
    void 이름의_길이가_유효하지_않은_경우_예외를_던진다(String invalidName) {
        // when & then
        assertThatThrownBy(() -> Coach.validate(invalidName)).isInstanceOf(IllegalArgumentException.class);
    }
}
