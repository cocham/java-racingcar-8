package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class NameTest {

    @Nested
    @DisplayName("Name 생성 테스트")
    class CreateNameTest {

        @Test
        @DisplayName("정상적인 이름을 생성한다")
        void createValidName() {
            assertDoesNotThrow(() -> new Name("pobi"));
        }

        @Test
        @DisplayName("5자 이하의 이름은 유효하다")
        void validNameLength() {
            assertDoesNotThrow(() -> new Name("jason"));
        }

        @Test
        @DisplayName("앞뒤 공백은 자동으로 제거된다")
        void trimWhitespace() {
            Name name = new Name("  pobi  ");
            assertThat(name.name()).isEqualTo("pobi");
        }
    }

    @Nested
    @DisplayName("Name 검증 테스트")
    class ValidateNameTest {

        @Test
        @DisplayName("빈 문자열은 예외를 발생시킨다")
        void emptyName() {
            assertThatThrownBy(() -> new Name(""))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("공백만 있는 이름은 예외를 발생시킨다")
        void blankName() {
            assertThatThrownBy(() -> new Name("   "))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("5자를 초과하는 이름은 예외를 발생시킨다")
        void nameTooLong() {
            assertThatThrownBy(() -> new Name("abcdef"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("5자");
        }

        @ParameterizedTest
        @ValueSource(strings = {"po bi", "po-bi", "po@bi"})
        @DisplayName("특수문자나 공백이 포함된 이름은 예외를 발생시킨다")
        void invalidCharacters(String invalidName) {
            assertThatThrownBy(() -> new Name(invalidName))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}