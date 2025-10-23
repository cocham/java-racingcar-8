package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private final String RACING_MESSAGE = "실행 결과";
    private final String COLON = " : ";
    private final String WINNER_MESSAGE = "최종 우승자";
    private final String WINNER_SEPARATOR = ", ";

    public void printRacingMessage() {
        System.out.println(RACING_MESSAGE);
    }

    public void printAllCarStatus(Cars cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + COLON + car.getStatus());
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
