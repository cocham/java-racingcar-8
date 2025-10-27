package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CarTest {

    @Nested
    @DisplayName("Car 생성 테스트")
    class CreateCarTest {

        @Test
        @DisplayName("정상적인 이름으로 자동차를 생성한다")
        void createCar() {
            assertDoesNotThrow(() -> new Car(new Name("pobi")));
        }

        @Test
        @DisplayName("초기 위치는 0이다")
        void initialPosition() {
            Car car = new Car(new Name("pobi"));
            assertThat(car.getDistance()).isEqualTo(0);
        }
    }

    @Nested
    @DisplayName("Car 이동 테스트")
    class MoveCarTest {

        @Test
        @DisplayName("전진 명령을 받으면 위치가 1 증가한다")
        void moveForward() {
            Car car = new Car(new Name("pobi"));
            car.moveForward();

            assertThat(car.getDistance()).isEqualTo(1);
        }

        @Test
        @DisplayName("여러 번 전진하면 위치가 누적된다")
        void moveForwardMultipleTimes() {
            Car car = new Car(new Name("pobi"));
            car.moveForward();
            car.moveForward();
            car.moveForward();

            assertThat(car.getDistance()).isEqualTo(3);
        }
    }
}