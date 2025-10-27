package racingcar;

import racingcar.controller.RaceController;
import racingcar.domain.MoveCondition;
import racingcar.domain.MoveConditions;
import racingcar.service.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        MoveCondition moveCondition = MoveConditions.random();
        Game game = new Game(moveCondition);
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RaceController raceController = new RaceController(game, inputView, outputView);
        raceController.run();
    }
}
