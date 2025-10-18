package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;


public class Application {

    private static final Calculator calculator = new Calculator();

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input;
        try {
            input = Console.readLine();
        } catch (NoSuchElementException e) {
            input = "";
        }

        int result = calculator.add(input);
        System.out.println("결과 : " + result);
    }


}
