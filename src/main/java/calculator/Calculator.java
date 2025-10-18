package calculator;

import calculator.core.CalculatorAggregator;
import calculator.core.CalculatorValidator;
import calculator.core.DelimiterExtractor;

/**
 * 계산기 연산 기능 클래스
 */
public class Calculator {

    Calculator() {
    }

    private final CalculatorValidator calculatorValidator = new CalculatorValidator();
    private final DelimiterExtractor delimiterExtractor = new DelimiterExtractor();
    private final CalculatorAggregator calculatorAggregator = new CalculatorAggregator();

    /**
     * 입력값 더하기 기능
     *
     * @param input 입력값
     * @return 합계
     */
    public Integer add(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        calculatorValidator.validateInput(input);
        DelimiterExtractor.ParseResult extract = delimiterExtractor.extract(input);

        String[] tokens = extract.getNormalizedInput().split(extract.getCustomDelimiter());

        return calculatorAggregator.sum(tokens);
    }

}
