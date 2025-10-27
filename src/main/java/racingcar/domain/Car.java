package racingcar.model;

import racingcar.service.MoveStrategy;

public class Car {
    private static final char MOVE_MARK = '-';
    private final Name name;
    private int distance = 0;
    private final MoveStrategy moveStrategy;

    public Car(Name name, MoveStrategy moveStrategy) {
        this.name = name;
        this.distance = 0;
        this.moveStrategy = moveStrategy;
    }

    public void moveIf(boolean shouldMove) {
        if (shouldMove) {
            moveForward();
        }
    }

    private void moveForward() {
        distance++;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name.name();
    }
}
