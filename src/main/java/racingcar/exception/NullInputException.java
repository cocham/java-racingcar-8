package racingcar.exception;

public class NullInputException extends IllegalArgumentException {
    public static final String DEFAULT_MESSAGE = "입력이 없습니다. (null)";

    public NullInputException() {
        super(DEFAULT_MESSAGE);
    }
}
