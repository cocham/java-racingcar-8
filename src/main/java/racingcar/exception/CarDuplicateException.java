package racingcar.exception;

public class CarDuplicateException extends IllegalArgumentException{
    public static final String DEFAULT_MESSAGE = "차 이름은 중복 될 수 없습니다.";
    public static final String CUSTOM_MESSAGE = "(%s)가 이미 존재합니다.";

    public CarDuplicateException(String car) {
        super(DEFAULT_MESSAGE + String.format(CUSTOM_MESSAGE, car));
    }
}
