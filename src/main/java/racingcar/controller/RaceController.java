package racingcar.controller;

import racingcar.model.Cars;
import racingcar.service.CarValidation;
import racingcar.service.Game;
import racingcar.service.GameValidation;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private final CarValidation carValidation = new CarValidation();
    private final GameValidation gameValidation = new GameValidation();
    private final Game game = new Game();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        String carsInput = inputView.printStartMessage();
        String[] raceCars = carValidation.returnCars(carsInput);
        Cars cars = new Cars(raceCars);
        String raceTimes = inputView.printRaceCountMessage();
        int attempt = gameValidation.returnRaceTime(raceTimes);
        outputView.printRacingMessage();
        for (int i = 0; i < attempt; i++) {
            game.playOneRound(cars);
            outputView.printAllCarStatus(cars);
        }

        outputView.printWinner(cars);
    }
}
