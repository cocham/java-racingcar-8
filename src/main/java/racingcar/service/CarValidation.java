package racingcar.service;

import racingcar.exception.CarDuplicateException;
import racingcar.exception.InvalidLengthException;
import racingcar.exception.InvalidNameException;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class CarValidation {
    private static final String DELIMITER = ",";
    private static final int LIMIT_LENGTH = 5;
    private static final String VALID_NAME_REGEX = "^[a-zA-Z0-9가-힣]*$";
    private static final Pattern VALID_NAME_PATTERN = Pattern.compile(VALID_NAME_REGEX);

    public String[] returnCars(String cars) {
        String[] raceCars = cars.split(DELIMITER);
        validateCars(raceCars);
        return raceCars;
    }

    private void validateCars(String[] raceCars) {
        Set<String> carsUniqueSpace = new HashSet<>(raceCars.length);

        for (String carName : raceCars) {
            carName = carName.trim();
            int nameLength = carName.length();
            if (nameLength > LIMIT_LENGTH) {
                throw new InvalidLengthException(carName, nameLength);
            }
            if (!VALID_NAME_PATTERN.matcher(carName).matches()) {
                throw new InvalidNameException(carName);
            }
            if (!carsUniqueSpace.add(carName)) {
                throw new CarDuplicateException(carName);
            }
        }
    }
}
