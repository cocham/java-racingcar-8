package racingcar.model;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private static final char MOVE_MARK = '-';
    private final Name name;
    private int distance = 0;

    public Car(Name name) {
        this.name = name;
        this.distance = 0;
    }

    public void attemptMove(int randomValue) {
        if (canMove(randomValue)) {
            moveForward();
        }
    }

    private boolean canMove(int randomValue) {
        return randomValue >= MOVE_THRESHOLD;
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
