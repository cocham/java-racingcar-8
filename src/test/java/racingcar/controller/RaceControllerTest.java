package racingcar.controller;

import racingcar.service.Game;
import racingcar.domain.MoveCondition;
import racingcar.domain.MoveConditions;
import racingcar.view.InputView;

import racingcar.view.TestInputView;
import racingcar.view.TestOutputView;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


class RaceControllerTest {

    @Test
    @DisplayName("무조건 전진하는 전략(AlwaysMove)으로 테스트")
    void 무조건_전진하는_전략으로_테스트() {
        MoveCondition alwaysMove = MoveConditions.always();
        Game testGame = new Game(alwaysMove);

        InputView testInput = new TestInputView("pobi,woni", "3");

        TestOutputView output = new TestOutputView();

        RaceController controller = new RaceController(testGame, testInput, output);

        controller.run();

        String result = output.getOutput();
        assertThat(result)
                .contains("pobi : ---")
                .contains("woni : ---")
                .contains("최종 우승자 : pobi, woni");
    }

    @Test
    @DisplayName("무조건 정지하는 전략(NeverMove)으로 테스트")
    void 무조건_정지하는_전략으로_테스트() {
        MoveCondition neverMove = MoveConditions.never();
        Game testGame = new Game(neverMove);
        InputView testInput = new TestInputView("pobi,woni", "3");
        TestOutputView output = new TestOutputView();
        RaceController controller = new RaceController(testGame, testInput, output);

        controller.run();

        String result = output.getOutput();
        assertThat(result)
                .contains("pobi : ")
                .contains("woni : ")
                .contains("최종 우승자 : pobi, woni");
    }
}

