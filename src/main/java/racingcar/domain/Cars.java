package racingcar.domain;

import racingcar.exception.CarDuplicateException;
import racingcar.exception.CarMinimumException;

import java.util.*;
import java.util.stream.Collectors;

public class Cars implements Iterable<Car> {
    private static final String DELIMITER = ",";
    private static final int MINIMUM_CARS_FOR_RACE = 2;
    private List<Car> cars = new ArrayList<>();

    public Cars(String carsInput) {
        String[] carNames = carsInput.split(DELIMITER);
        if (carNames.length < MINIMUM_CARS_FOR_RACE) {
            throw new CarMinimumException(MINIMUM_CARS_FOR_RACE);
        }
        List<Name> names = Arrays.stream(carNames)
                .map(Name::new)
                .collect(Collectors.toList());
        validateDuplicates(names);
        this.cars = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void  validateDuplicates(List<Name> names) {
        Set<Name> uniqueNames = new HashSet<>();
        for (Name name : names) {
            if (!uniqueNames.add(name)) {
                throw new CarDuplicateException(name.name());
            }
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
