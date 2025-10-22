package racingcar.service;

import racingcar.exception.InvalidRaceException;

public class GameValidation {
    final int MINIMUM_RACE_TIME = 1;
    final int MAXIMUM_RACE_TIME = 50;

    public void validateRaceTime(String time){
        int num = parseRaceTime(time);
        validateRace(num);
    }

    public void validateRace(int num){
        if (num < MINIMUM_RACE_TIME || num > MAXIMUM_RACE_TIME) {
            throw new InvalidRaceException(MINIMUM_RACE_TIME, MAXIMUM_RACE_TIME);
        }
    }

    public int parseRaceTime(String time) {
        try {
            return Integer.parseInt(time);
        } catch (NumberFormatException e) {
            throw new InvalidRaceException();
        }
    }

}
