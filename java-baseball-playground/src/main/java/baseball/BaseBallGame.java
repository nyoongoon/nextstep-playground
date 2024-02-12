package baseball;

import java.util.Scanner;

public class BaseBallGame {
    Scanner scanner = new Scanner(System.in);
    String number;

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void setting() {
        number = String.valueOf((int) (Math.random() * 899) + 100);
    }

    public boolean validateDigits(String input) {
        int number = Integer.parseInt(input);
        if (100 <= number && number <= 999) {
            return true;
        }
        return false;
    }

    public void manualSetting() {
        System.out.println("숫자를 입력해주세요.");
        // 입력받기 &&  변환 가능 판단
        String input = scanner.nextLine();
        this.number = getInputNumber(input);
    }

    public String getInputNumber(String input) {
        String result = checkNumeric(input); //숫자인지 판단
        return checkDigits(result); //자리수 판단
    }

    public String checkNumeric(String input) {
        String result = input;
        // 변환
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("잘못된 숫자입니다. 다시 입력해 주세요.");
            String reInput = this.scanner.nextLine();
            result = getInputNumber(reInput);
        }
        return result;
    }

    public String checkDigits(String input) {
        String result = input;
        // 자리수
        while (!validateDigits(this.number)) {
            System.out.println("범위를 벗어났습니다. 다시 입력해주세요.");
            result = getInputNumber(scanner.nextLine());
        }
        return result;
    }


    public void judge(String input) {
        int ballCnt = 0;
        int strikeCnt = 0;
        String ball = getInputNumber(input);

        for (int i = 0; i < number.length(); i++) {
            int ballResult = isBall(number, ball, i) ? 1 : 0;
            ballCnt += ballResult;
        }

        for (int i = 0; i < number.length(); i++) {
            strikeCnt += plusIfStrike(number, ball, i);
        }
    }

    public boolean isBall(String number, String ball, int ballIdx) {
        boolean result = false;
        char ballChar = ball.charAt(ballIdx);

        for (int i = 0; i < number.length(); i++) {
            char numberChar = number.charAt(i);
            result = isEqualCharExcepIdx(numberChar, ballChar, i, ballIdx);
        }

        return result;
    }


    public boolean isEqualCharExcepIdx(char numberChar, char ballChar, int numberIdx, int ballIdx) {
        if (numberIdx != ballIdx && numberChar == ballChar) {
            return true;
        }
        return false;
    }


    public int plusIfStrike(String number, String ball, int idx) {
        if (number.charAt(idx) == ball.charAt(idx)) {
            return 1;
        }
        return 0;
    }

}
