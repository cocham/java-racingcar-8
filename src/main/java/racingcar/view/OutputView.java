package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String RACING_MESSAGE = "실행 결과";
    private static final String COLON = " : ";
    private static final String WINNER_MESSAGE = "최종 우승자";
    private static final String WINNER_SEPARATOR = ", ";
    private static final String MOVE_MARK = "-";

    public void printRacingMessage() {
        System.out.println(RACING_MESSAGE);
    }

    public void printAllCarStatus(Cars cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + COLON + MOVE_MARK.repeat(car.getDistance()));
        }
        System.out.println();
    }

    public void printWinner(Cars cars) {
        List<Car> winners = cars.getWinners();
        String winnerNames = winners.stream()
                    .map(Car::getName)
                    .collect(Collectors.joining(WINNER_SEPARATOR));

        System.out.println(WINNER_MESSAGE + COLON + winnerNames);
    }
}
