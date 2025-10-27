package racingcar.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestOutputView extends OutputView {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    public TestOutputView() {
        System.setOut(new PrintStream(outContent));
    }

    public String getOutput() {
        System.setOut(originalOut);
        return outContent.toString();
    }
}
