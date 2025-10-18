package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
//      1. 입력
//      덧셈할 문자열을 입력해 주세요. 출력
        System.out.println("덧셈할 문자열을 입력해 주세요.");
//      문자열 입력 (Console.readLine() 사용)
        String input = Console.readLine();

//      2. 기본 구분자로 String 배열 생성
//      , 과 : 을 구분자로 활용하여 숫자 추출
        String[] stringNumbers = input.split("[,:]+");

//      4. 덧셈 로직
//      String 배열 요소 -> int 배열로 변경
        int[] numbers = new int[stringNumbers.length];
        for(int i = 0; i<stringNumbers.length; i++) {
            numbers[i] = Integer.parseInt(stringNumbers[i]);
        }

//      각 숫자들 덧셈
        int result = 0;
        for(int i = 0; i<numbers.length; i++) {
            result += numbers[i];
        }

//      3. 커스텀 구분자로 String 배열 생성
//      커스텀 문자를 추출하여 숫자 추출 (//<커스텀 구분자>\n)

//      4. 덧셈 로직
//      String 배열 요소 -> int 배열로 변경
//      각 숫자들 덧셈

//      5. 출력
//      결과 : <결과값> 출력

//      6. 예외처리
//      사용자가 잘못된 값을 입력할 경우 ‘IllegalArgumentException’을 발생시킨 후 애플리케이션은 종료
//      음수 입력, 형식(커스텀 문자 정의없이 커스텀 문자 사용)이 잘못된 문자열 예외 처리
//      “” 빈 문자열 입력 시 0 반환
//      종료 시 System.exit() 사용 금지
    }
}
