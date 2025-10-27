package racingcar.domain;

public class Car {
    private static final char MOVE_MARK = '-';
    private final Name name;
    private int distance = 0;

    public Car(Name name) {
        this.name = name;
        this.distance = 0;
    }

    public void moveForward() {
        distance++;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name.name();
    }
}
