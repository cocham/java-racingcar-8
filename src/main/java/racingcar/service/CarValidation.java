package racingcar.service;

import racingcar.exception.CarDuplicateException;
import racingcar.exception.InvalidLengthException;

import java.util.HashSet;
import java.util.Set;

public class CarValidation {
    private static final String DELIMITER = ",";
    private static final int LIMIT_LENGTH = 5;

    public String[] returnCars(String cars) {
        String[] raceCars = cars.split(DELIMITER);
        validateCars(raceCars);
        return raceCars;
    }

    private void validateCars(String[] raceCars) {
        Set<String> carsUniqueSpace = new HashSet<>(raceCars.length);

        for (String car : raceCars) {
            car = car.trim();
            int length = car.length();
            if (length > LIMIT_LENGTH) {
                throw new InvalidLengthException(car, length);
            }
            if (!carsUniqueSpace.add(car)) {
                throw new CarDuplicateException(car);
            }
        }
    }
}
