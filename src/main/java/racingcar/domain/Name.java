package racingcar.domain;

import racingcar.exception.InvalidLengthException;
import racingcar.exception.InvalidNameException;

import java.util.regex.Pattern;

public record Name(String name) {
    private static final String VALID_NAME_REGEX = "^[a-zA-Z0-9가-힣]+$";
    private static final Pattern VALID_NAME_PATTERN = Pattern.compile(VALID_NAME_REGEX);
    private static final int VALID_NAME_MAX_LENGTH = 5;

    public Name {
        name = name.trim();
        validateName(name);
    }

    private void validateName(String name) {
        int nameLength = name.length();
        validateLength(nameLength);
        validateNameForm(name);
    }

    private void validateLength(int length) {
        if (length > VALID_NAME_MAX_LENGTH) {
            throw new InvalidLengthException(name, length);
        }
    }

    private void validateNameForm(String name) {
        if (!VALID_NAME_PATTERN.matcher(name).matches()) {
            throw new InvalidNameException(name);
        }
    }

}
