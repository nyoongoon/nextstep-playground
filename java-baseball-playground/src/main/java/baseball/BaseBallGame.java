package baseball;

import java.util.Scanner;

public class BaseBallGame {
    Scanner scanner = new Scanner(System.in);
    int number;

    public void setting() {
        number = (int) (Math.random() * 899) + 100;
    }

    public void manualSetting() {
        System.out.println("숫자를 입력해주세요.");
        // 입력받기 &&  변환 가능 판단
        String input = scanner.nextLine();
        number = transToNum(input, scanner);


        // 변환

        // 자리수


//        while(number == null){
//            System.out.println("숫자를 입력해주세요.");
//        }
//        while(str.length() != 3){
//            System.out.println("올바른 숫자를 입력해주세요.");
//            str = scanner.nextLine();
//        }
//        number = str;
    }

    public int transToNum(String input, Scanner scanner) {
        int result = 0;
        try {
            result = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("잘못된 숫자입니다. 다시 입력해 주세요.");
            String reInput
            result = transToNum()
        }
        return null;
    }
}
