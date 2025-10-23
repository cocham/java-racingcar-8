package racingcar.service;

import racingcar.exception.InvalidRaceException;

public class GameValidation {
    private static final int MINIMUM_RACE_TIME = 1;
    private static final int MAXIMUM_RACE_TIME = 50;

    public int returnRaceTime(String time){
        int num = parseRaceTime(time);
        validateRaceTime(num);
        return num;
    }

    private void validateRaceTime(int num){
        if (num < MINIMUM_RACE_TIME || num > MAXIMUM_RACE_TIME) {
            throw new InvalidRaceException(MINIMUM_RACE_TIME, MAXIMUM_RACE_TIME);
        }
    }

    private int parseRaceTime(String time) {
        try {
            return Integer.parseInt(time);
        } catch (NumberFormatException e) {
            throw new InvalidRaceException();
        }
    }

}
