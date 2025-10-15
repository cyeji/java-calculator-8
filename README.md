# java-calculator-precourse
# 문자열 덧셈 계산기

---

## 🧠 기능 목록
> 구현 전 반드시 기능 단위로 커밋하세요.  
> 커밋 메시지는 [AngularJS Commit Message Conventions](https://github.com/angular/angular.js/blob/master/DEVELOPERS.md#commits)을 따릅니다.

- [ ] 문자열 입력받기 (`Console.readLine()`)
- [ ] 빈 문자열 처리 (`""` → 0)
- [ ] 기본 구분자(쉼표, 콜론)로 분리
- [ ] 커스텀 구분자 파싱 (`//<delimiter>\n`)
- [ ] 숫자 합산 로직 구현
- [ ] 잘못된 입력(음수, 숫자 외) 검증
- [ ] 결과 출력

---

## 💡 예외 상황 정의
- 음수 또는 숫자가 아닌 값 입력 시 → `IllegalArgumentException`
- 구분자만 있고 숫자가 없는 경우 → `IllegalArgumentException`

---

## 🧩 프로그래밍 요구 사항

- Java 21 버전에서 실행 가능해야 한다.
- 프로그램의 시작점은 `Application` 클래스의 `main()` 메서드이다.
- `camp.nextstep.edu.missionutils.Console` API를 사용하여 입력을 처리한다.
- `System.exit()` 호출 금지
- `build.gradle` 파일 수정 금지
- 제공된 라이브러리 외 외부 라이브러리 사용 금지
- Java Style Guide를 준수할 것

---

## 🧪 테스트 실행 가이드

Mac/Linux:
```bash
./gradlew clean test