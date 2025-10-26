package racingcar.model;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private static final char MOVE_MARK = '-';
    private final Name name;
    private final StringBuilder status = new StringBuilder();

    public Car(Name name) {
        this.name = name;
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
        status.append(MOVE_MARK);
    }

    public String getStatus() {
        return status.toString();
    }

    public int getDistance() {
        return status.length();
    }

    public String getName() {
        return name.name();
    }
}
