package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        int result = add(input);
        System.out.println("결과 : " + result);
    }

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = "[,:]";
        String numbers = input;

        if (input.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\\\\n(.*)").matcher(input);
            if (matcher.find()) {
                delimiter = Pattern.quote(matcher.group(1));
                numbers = matcher.group(2);
            } else {
                throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
            }
        }

        String[] tokens = numbers.split(delimiter);
        int sum = 0;

        for (String token : tokens) {
            if (token.isEmpty()) continue;
            int number = parsePositiveInt(token);
            sum += number;
        }

        return sum;
    }

    private static int parsePositiveInt(String str) {
        try {
            int number = Integer.parseInt(str);
            if (number < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + str);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + str);
        }
    }
}
