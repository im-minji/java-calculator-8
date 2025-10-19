package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
//      1. 사용자 입력
        String input = inputConsole();

//      예외처리: “” 빈 문자열 입력 시 0 반환
        if(isEmpty(input)) {
            return;
        }

//      3. 구분자로 String 배열 생성
        String[] stringNumbers = splitInput(input);

//      4. String 배열 요소 -> int[]로 변환 + 예외처리
        int[] stringToNumbers = stringToNumbers(stringNumbers);

//      5. int[] 배열 요소 덧셈
        int result = addNumbers(stringToNumbers);

//      6. 결과 출력
        outputConsole(result);

    }

    static String inputConsole() {
        //      1. 입력
//      덧셈할 문자열을 입력해 주세요. 출력
        System.out.println("덧셈할 문자열을 입력해 주세요.");
//      문자열 입력 (Console.readLine() 사용)
        return Console.readLine();
    }

    static Boolean isEmpty(String input) {
//      6. 예외처리
//      사용자가 잘못된 값을 입력할 경우 ‘IllegalArgumentException’을 발생시킨 후 애플리케이션은 종료
//      “” 빈 문자열 입력 시 0 반환
        if(input.isEmpty()) {
            System.out.println("결과 : " + 0);
            return true;
        }
        return false;
    }

    static String[] splitInput(String input) {
        String delimeter = "";

        if (input.startsWith("//")) {
            int firstIndex = input.indexOf("//");
            int lastIndex = input.indexOf("\\n");

            if (firstIndex != -1 && lastIndex != -1) {
                delimeter = input.substring(firstIndex + 2, lastIndex);
            }

//      6. 예외처리
//      사용자가 잘못된 값을 입력할 경우 ‘IllegalArgumentException’을 발생시킨 후 애플리케이션은 종료
//      음수 입력, 형식(커스텀 문자 정의없이 커스텀 문자 사용)이 잘못된 문자열 예외 처리
            if (delimeter.isEmpty()) {
                throw new IllegalArgumentException("커스텀 문자를 입력해주세요.");
            }

            String customString = input.substring(lastIndex + 2);
            return customString.split(delimeter);
        }
        return input.split("[,:]+");
    }

    static int[] stringToNumbers(String[] stringNumbers) {
//      4. 덧셈 로직
//      String 배열 요소 -> int 배열로 변경
        int[] stringToNumbers = new int[stringNumbers.length];
        for(int i = 0; i<stringToNumbers.length; i++) {
//      6. 예외처리
//      사용자가 잘못된 값을 입력할 경우 ‘IllegalArgumentException’을 발생시킨 후 애플리케이션은 종료
//      음수 입력, 형식(커스텀 문자 정의없이 커스텀 문자 사용)이 잘못된 문자열 예외 처리
            try{
                stringToNumbers[i] = Integer.parseInt(stringNumbers[i]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값은 계산할 수 없습니다.");
            }

            if(stringToNumbers[i] < 0) {
                throw new IllegalArgumentException("음수는 계산할 수 없습니다.");
            }
        }
        return stringToNumbers;
    }

    static int addNumbers(int[] stringToNumbers) {
//      각 숫자들 덧셈
        int result = 0;
        for(int i = 0; i<stringToNumbers.length; i++) {
            result += stringToNumbers[i];
        }
        return result;
    }

    static void outputConsole(int result) {
//      5. 출력
//      결과 : <결과값> 출력
        System.out.println("결과 : " + result);
    }

}
