package racingcar.domain;

public class NeverMoveCondition implements MoveCondition {
    @Override
    public boolean canMove() {
        return false;
    }
}