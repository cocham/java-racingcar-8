package racingcar.service;

import racingcar.model.Car;
import racingcar.model.Cars;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Game {
    public void playOneRound(Cars cars) {
            playCars(cars);
    }

    private void playCars(Cars cars) {
        for (Car car : cars) {
            playRound(car);
        }
    }

    private void playRound(Car car) {
        int n = pickNumberInRange(0,9);
        if (n >= 4) {
            car.moveForward();
        }
    }
}
