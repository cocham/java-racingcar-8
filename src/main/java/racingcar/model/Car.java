package racingcar.model;

public class Car {
    private String name;
    private StringBuilder status;

    public Car(String name) {
        this.name = name;
        this.status = new StringBuilder();
    }

    public void moveForward() {
        status.append("-");
    }

    public String getStatus() {
        return status.toString();
    }

    public int getDistance() {
        return status.length();
    }

    public String getName() {
        return name;
    }
}
