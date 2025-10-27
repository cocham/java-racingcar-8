package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.MoveCondition;

public class Game {
    private final MoveCondition moveCondition;

    public Game(MoveCondition moveCondition) {
        this.moveCondition = moveCondition;
    }


    public void playOneRound(Cars cars) {
        for (Car car : cars) {
            if (moveCondition.canMove()) {
                car.moveForward();
            }
        }
    }
}
