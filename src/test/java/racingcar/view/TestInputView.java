package racingcar.view;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TestInputView implements InputView {
    private final Queue<String> inputs;

    public TestInputView(String... inputs) {
        this.inputs = new LinkedList<>(Arrays.asList(inputs));
    }

    @Override
    public String readCarNames() {
        return inputs.poll();
    }

    @Override
    public String readRaceCount() {
        return inputs.poll();
    }
}
