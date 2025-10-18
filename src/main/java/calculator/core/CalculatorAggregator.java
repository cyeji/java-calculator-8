package calculator.core;

/**
 * 계산기 연산 클래스
 */
public class CalculatorAggregator {

    /**
     * 더하기 연산 메소드
     *
     * @param tokens 추출한 연산 값
     * @return 더하기 연산 결과
     */
    public Integer sum(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            if (!token.isEmpty()) {
                int number = Integer.parseInt(token);
                if (number < 0) {
                    throw new IllegalArgumentException();
                }
                sum += number;
            }
        }
        return sum;
    }

}
