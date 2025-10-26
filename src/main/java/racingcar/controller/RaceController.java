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

        Cars cars = new Cars(carsInput);

        outputView.printRacingMessage();
            game.playOneRound(cars);
            outputView.printAllCarStatus(cars);
        }

        outputView.printWinner(cars);
    }
}
