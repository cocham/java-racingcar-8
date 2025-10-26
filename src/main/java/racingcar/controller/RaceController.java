package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.RaceCount;
import racingcar.service.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private final Game game = new Game();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        String carsInput = inputView.printStartMessage();
        String raceCountInput = inputView.printRaceCountMessage();

        Cars cars = new Cars(carsInput);
        RaceCount raceCount = new RaceCount(raceCountInput);

        outputView.printRacingMessage();
        for (int i = 0; i < raceCount.count(); i++) {
            game.playOneRound(cars);
            outputView.printAllCarStatus(cars);
        }

        outputView.printWinner(cars);
    }
}
