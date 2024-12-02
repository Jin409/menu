package menu;

import java.util.Set;
import menu.view.validator.InputValidator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"코치 코치 코치 코치"})
    void 잘못된_코치_이름_입력_형식에_대해_예외를_던진다(String invalidName) {
        // when & then
        assertThatThrownBy(() -> InputValidator.validateCoachNames(invalidName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"코치,코치,코치"})
    void 코치_이름이_중복되는_경우_예외를_던진다(String invalidName) {
        // when & then
        assertThatThrownBy(() -> InputValidator.validateCoachNames(invalidName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
