package calculator.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 구분자 추출 클래스
 */
public class DelimiterExtractor {

    private static final Pattern CUSTOM_DELIMITER_REGEX = Pattern.compile("//(.)\\\\n(.*)");

    public DelimiterExtractor() {
    }

    /**
     * 입력값 추출
     *
     * @param input 입력값
     * @return
     */
    public ParseResult extract(String input) {

        Matcher matcher = CUSTOM_DELIMITER_REGEX.matcher(input);

        if (matcher.find()) {
            String delimiter = Pattern.quote(matcher.group(1));
            String numbers = matcher.group(2);
            return new ParseResult(numbers, delimiter);
        }

        return new ParseResult(input);
    }

    public static class ParseResult {
        private String normalizedInput = "";
        private String customDelimiter = "[,:]";

        public ParseResult(String normalizedInput, String customDelimiter) {
            this.normalizedInput = normalizedInput;
            this.customDelimiter = customDelimiter;
        }

        public ParseResult(String input) {
            this.normalizedInput = input;
        }

        public String getNormalizedInput() {
            return normalizedInput;
        }

        public String getCustomDelimiter() {
            return customDelimiter;
        }

    }

}
