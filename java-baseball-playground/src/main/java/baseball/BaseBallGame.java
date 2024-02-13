package baseball;

import java.util.Scanner;

public class BaseBallGame {
    Scanner scanner = new Scanner(System.in);
    String number;
    int ballCnt;
    int strikeCnt;

    public void startGame(){
        setting();
        System.out.println("숫자를 입력해주세요.");
        // 입력받기 &&  변환 가능 판단
        String input = scanner.nextLine();
        judge(input);
    }

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

    public String getInputGameOption(String input){
        String result = checkNumeric(input); //숫자인지 판단
        return checkDigits(result, 1, 9);
    }

    // 게임 숫자 3자리수 받기
    public String getInputNumber(String input) {
        String result = checkNumeric(input); //숫자인지 판단
        return checkDigits(result, 100, 999); //자리수 판단
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

    public String checkDigits(String input, int startNum, int endNum) {
        String result = input;
        int num = Integer.parseInt(input);
        // 자리수
        //while (!validateDigits(result)) {
        while (startNum > num || endNum < num) {
            System.out.println("범위를 벗어났습니다. 다시 입력해주세요.");
            result = getInputNumber(scanner.nextLine());
            num = Integer.parseInt(result);

        return result;
    }

    public void gameResult(){
        if(this.ballCnt != 0){
            System.out.printf("%d볼 ", this.ballCnt);
        }
        if(this.strikeCnt != 0){
            System.out.printf("%d스트라이크 ", this.ballCnt);
        }
        System.out.println();
        if(this.strikeCnt == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }

        boolean isReGame = getInputGameOption();
        if(!isReGame){
            System.out.println("숫자를 입력해주세요.");
            String input = scanner.nextLine();
            judge(input);
        }
        startGame();
    }

    public void judge(String input) {
        this.ballCnt = 0;
        this.strikeCnt = 0;
        String ball = getInputNumber(input);

        for (int i = 0; i < ball.length(); i++) {
            int ballResult = isBall(number, ball, i) ? 1 : 0;
            ballCnt += ballResult;
        }

        for (int i = 0; i < ball.length(); i++) {
            int strikeResult = isStrike(number, ball, i) ? 1 : 0;
            strikeCnt += strikeResult;
        }

        gameResult();
    }

    public boolean isBall(String number, String ball, int ballIdx) {
        boolean result = false;
        char ballChar = ball.charAt(ballIdx);

        int numberIdx = 0;
        while (!result && numberIdx < number.length()) {
            char numberChar = number.charAt(numberIdx);
            result = isEqualCharExceptIdx(numberChar, ballChar, numberIdx++, ballIdx);
        }

        return result;
    }


    public boolean isEqualCharExceptIdx(char numberChar, char ballChar, int numberIdx, int ballIdx) {
        if (numberIdx != ballIdx && numberChar == ballChar) {
            return true;
        }
        return false;
    }


    public boolean isStrike(String number, String ball, int ballIdx) {
        if (number.charAt(ballIdx) == ball.charAt(ballIdx)) {
            return true;
        }
        return false;
    }

}
