package calculator.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 계산기 검증 클래스
 */
public class CalculatorValidator {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\\\n(.*)");
    private static final String BASIC_INPUT_PATTERN = "^[0-9,:]+$";

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
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
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
        if (!input.matches(BASIC_INPUT_PATTERN)) {
            throw new IllegalArgumentException();
        }
    }

}
