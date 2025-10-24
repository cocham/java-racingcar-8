package racingcar.service;

import racingcar.model.Car;
import racingcar.model.Cars;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Game {
    public void playOneRound(Cars cars) {
        for (Car car : cars) {
            int randomValue = pickNumberInRange(0,9);
            car.attemptMove(randomValue);
        }
    }
}
