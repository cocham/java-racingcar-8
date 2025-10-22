package racingcar.exception;

public class InvalidLengthException extends IllegalArgumentException {
    public static final String DEFAULT_MESSAGE = "자동차의 이름은 5자 이하만 가능합니다.\n";
    public static final String CUSTOM_MESSAGE = "(%s)의 이름이 (%d) 글자입니다.";

    public InvalidLengthException(String car, int length) {
        super(DEFAULT_MESSAGE + String.format(CUSTOM_MESSAGE, car, length));
    }
}
