import org.example.ArithmeticOperator;
import org.example.calculate.*;

import java.util.List;

public class Calculator {

    private static final List<NewArithmeticOperator> arithmeticOperators = List.of(new AdditionOperator(), new SubtractionOperator(), new MultiplicationOperator(), new DivisionOperator());
    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {
        /* 계산 요청이 들어 왔을때 자신이 직접 계산하는 것이 아니라,
        if ("+".equals(operator)) {
            return operand1 + operand2;
        } else if("-".equals(operator)) {
            return operand1 - operand2;
        } else if("*".equals(operator)) {
            return operand1 * operand2;
        } else if("/".equals(operator)) {
            return operand1 / operand2;
        }
        return 0;
        */

        /* 상위 인터페이스인 NewArithmeticOperator에서 받는다.
       return ArithmeticOperator.calculate(operand1, operator, operand2);
       */
        return arithmeticOperators.stream()
                .filter(arithmeticOperators -> arithmeticOperators.supports(operator))
                .map(arithmeticOperators -> arithmeticOperators.calculate(operand1, operand2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
    }
}
