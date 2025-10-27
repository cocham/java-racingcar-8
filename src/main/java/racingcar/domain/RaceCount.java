package racingcar.model;

import racingcar.exception.InvalidRaceException;

public record RaceCount(int count) {
    private static final int MINIMUM_RACE_TIME = 1;
    private static final int MAXIMUM_RACE_TIME = 50;

    public RaceCount(String raceCountInput) {
        this(parseRaceTime(raceCountInput));
    }

    public RaceCount {
        validateRaceTime(count);
    }

    private static void validateRaceTime(int num){
        if (num < MINIMUM_RACE_TIME || num > MAXIMUM_RACE_TIME) {
            throw new InvalidRaceException(MINIMUM_RACE_TIME, MAXIMUM_RACE_TIME);
        }
    }

    private static int parseRaceTime(String time) {
        try {
            return Integer.parseInt(time);
        } catch (NumberFormatException e) {
            throw new InvalidRaceException();
        }
    }
}
