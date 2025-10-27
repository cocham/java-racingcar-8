package racingcar.domain;

public class MoveConditions {
    private MoveConditions() {}

    public static MoveCondition random() {
        return new RandomMoveCondition();
    }

    public static MoveCondition always() {
        return new AlwaysMoveCondition();
    }

    public static MoveCondition never() {
        return new NeverMoveCondition();
    }

}
