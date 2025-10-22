package racingcar.exception;

public class InvalidRaceException extends IllegalArgumentException {
    public static final String DEFAULT_MESSAGE = "경기를 진행할 수 없습니다.\n";
    public static final String NUMBER_CUSTOM_MESSAGE = "경기 횟수는 (%d)번 이상 (%d)번 이하여야 합니다.";
    public static final String INVALID_NUMBER_CUSTOM_MESSAGE = "경기 횟수는 정수여야 합니다.";

    public InvalidRaceException(int minTime, int maxTime) {
        super(DEFAULT_MESSAGE + String.format(NUMBER_CUSTOM_MESSAGE, minTime, maxTime));
    }

    public InvalidRaceException() {
        super(DEFAULT_MESSAGE + INVALID_NUMBER_CUSTOM_MESSAGE);
    }
}
