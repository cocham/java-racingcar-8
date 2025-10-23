package racingcar.exception;

public class InvalidNameException extends IllegalArgumentException{
    public static final String DEFAULT_MESSAGE = "자동차 이름에 특수문자를 사용할 수 없습니다: ";

    public InvalidNameException(String car) {
        super(DEFAULT_MESSAGE + car);
    }
}
