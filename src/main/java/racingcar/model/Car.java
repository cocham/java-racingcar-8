package racingcar.model;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private final Name name;
    private StringBuilder status;

    public Car(Name name) {
        this.name = name;
        this.status = new StringBuilder();
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
        status.append("-");
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
