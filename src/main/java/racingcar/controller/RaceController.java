package racingcar.controller;

import racingcar.domain.*;
import racingcar.service.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private final Game game;
    private final InputView inputView;
    private final OutputView outputView;

    public RaceController(Game game, InputView inputView, OutputView outputView) {
        this.game = game;
        this.inputView = inputView;
        this.outputView = outputView;
    }

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
