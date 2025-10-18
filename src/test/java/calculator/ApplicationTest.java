package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    // 과제 요구사항 예시 테스트
    @Test
    @DisplayName("과제 예시 - 쉼표 구분자 기본")
    void 과제예시_쉼표_기본() {
        assertSimpleTest(() -> {
            run("1,2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    @DisplayName("과제 예시 - 쉼표 구분자 여러 숫자")
    void 과제예시_쉼표_여러숫자() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    @DisplayName("과제 예시 - 커스텀 구분자 세미콜론")
    void 과제예시_커스텀_세미콜론() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    @DisplayName("커스텀 구분자 - 리터럴 \\n 형태도 인식")
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    @DisplayName("음수 입력 시 예외")
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("빈값 입력 - 빈값 입력 시 0 결과")
    void 빈값입력() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    @DisplayName("허용되지 않은 문자 포함 시 예외")
    void 허용되지않은_문자_사용() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("_1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("커스텀 구분자 - 여러 문자 입력 시 예외")
    void 커스텀_구분자_여러문자_예외() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//;;\\n1;2;3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("커스텀 파이프(|) 구분자 - 리터럴 \\n")
    void 커스텀_파이프_리터럴n() {
        assertSimpleTest(() -> {
            run("//|\\n10|20|30");
            assertThat(output()).contains("결과 : 60");
        });
    }

    @Test
    @DisplayName("기본 구분자(쉼표, 콜론) 혼용")
    void 더하기연산_결과_성공() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    @DisplayName("실수 연산 불가")
    void 실수_연산_에러() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1.1231,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("커스텀 연산자 외 다른 연산자 입력 가능")
    void 커스텀연산자_기본연산자_동시사용가능() {
        assertSimpleTest(() -> {
            run("//|\\n10|20,30");
            assertThat(output()).contains("결과 : 60");
        });
    }

    @Test
    @DisplayName("기본 구분자 외 다른 구분자 입력 시 오류")
    void 다른_구분자_입력_시_오류() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2;3;4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
