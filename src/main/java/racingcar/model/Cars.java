package racingcar.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars implements Iterable<Car> {
    private List<Car> cars = new ArrayList<>();

    public Cars(String[] raceCars) {
        for (String name : raceCars) {
            Car car = new Car(name);
            cars.add(car);
        }
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }

    public List<Car> getWinners() {
        int maxDistance = findMaxDistance();
        return filterByDistance(maxDistance);
    }

    private int findMaxDistance() {
        return cars.stream()
            .mapToInt(Car::getDistance)
            .max()
            .orElse(0);
    }

    private List<Car> filterByDistance(int maxDistance) {
        return cars.stream()
            .filter(car -> car.getDistance() == maxDistance)
            .collect(Collectors.toList());
    }
}
