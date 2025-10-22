package racingcar.service;

import racingcar.exception.CarDuplicateException;
import racingcar.exception.InvalidLengthException;
import racingcar.model.Car;

import java.util.HashSet;
import java.util.Set;

public class CarValidation {
    public final String DELIMITER = ",";

    public void validateCarName(String cars) {
        String[] carsInventory = cars.split(DELIMITER);
        Set<String> carsUniqueSpace = new HashSet<>(carsInventory.length);

        for (String car : carsInventory) {
            car = car.trim();
            int length = car.length();
            if (length > 5) {
                throw new InvalidLengthException(car, length);
            }
            if (!carsUniqueSpace.add(car)) {
                throw new CarDuplicateException(car);
            }
        }
    }


}
