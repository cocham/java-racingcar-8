package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.NullInputException;

public class InputView {
    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACE_TIMES_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public String printStartMessage() {
        System.out.println(START_MESSAGE);
        return readValidateInput();
    }

    public String printRaceCountMessage() {
        System.out.println(RACE_TIMES_MESSAGE);
        return readValidateInput();
    }

    private String readValidateInput() {
        String input = Console.readLine();
        if (input == null) {
            throw new NullInputException();
        }
        return input;
    }
}
