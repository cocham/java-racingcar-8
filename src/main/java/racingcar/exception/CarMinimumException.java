package racingcar.exception;

public class CarMinimumException extends IllegalArgumentException {
    public static final String DEFAULT_MESSAGE = "경주를 위해서는 최소 %d대의 자동차가 필요합니다.\n";;

    public CarMinimumException(int minimumCars) {
        super(DEFAULT_MESSAGE);
    }
}
