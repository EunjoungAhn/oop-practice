import org.example.calculate.PositiveNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CalculatorTest {

    // 1 + 2 --> Calculator
    //   3   <--
    @DisplayName("사칙 연산을 수행한다.")
    @ParameterizedTest
    @MethodSource("formulaAndResult")
    void additionTest(int operand1, String operator, int operand2, int result) {

        int calculateResult = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));

        assertThat(calculateResult).isEqualTo(result);
    }

    private static Stream<Arguments> formulaAndResult(){
        return Stream.of(
                arguments(1, "+", 2, 3),
                arguments(1, "-", 2, -1),
                arguments(4, "*", 2, 8),
                arguments(4, "/", 2, 2)
        );
    }

    /*
    사칙연산 하나로 합치기
    @DisplayName("뺼셈 연산을 수행한다.")
    @Test
    void subtractionTest() {

        int result = Caluator.calculate(1, "-", 2);

        assertThat(result).isEqualTo(-1);
    }
    */

    /* 리팩토링한 코드가 더이상 음수이지 않기 때문에 테스트 코드의 의미가 사라진다.
    @DisplayName("나눗셈에서 0을 나누는 경우 예외를 발생시킨다.")
    @ParameterizedTest
    @MethodSource("formulaAndResult")
    void calculateExceptionTest(int operand1, String operator, int operand2, int result) {
        assertThatCode(() -> Calculator.calculate(new PositiveNumber(10), "/", new PositiveNumber(0)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0으로는 나눌 수 없습니다.");
    }
    */
}
