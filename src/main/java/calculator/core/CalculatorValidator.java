package calculator.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 계산기 검증 클래스
 */
public class CalculatorValidator {

    /**
     * 입력값 검증
     *
     * @param input 입력값
     */
    public void validateInput(String input) {
        if (!input.startsWith("//")) {
            validateInputWithoutCustomDelimiter(input);
            return;
        }

        validateInputWithCustomDelimiter(input);
    }

    /**
     * 커스텀 문자열이 포함된 입력값 검증
     *
     * @param input 입력값
     */
    private void validateInputWithCustomDelimiter(String input) {
        Matcher matcher = Pattern.compile("//(.)\\\\n(.*)").matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException();
        } 
    }

    /**
     * 커스텀 문자열이 없는 입력값 검증
     *
     * @param input 입력값
     */
    void validateInputWithoutCustomDelimiter(String input) {
        if (!input.matches("^[0-9,:]+$")) {
            throw new IllegalArgumentException();
        }

    }

}
