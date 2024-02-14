package baseball;

import java.util.Scanner;

public class BaseBallGame {
    Scanner scanner = new Scanner(System.in);
    String number;
    boolean isOnGame;

    public class GameResult{
        int ballCnt;
        int strikeCnt;

        public GameResult() {
            this.ballCnt = 0;
            this.strikeCnt = 0;
        }
    }

    public void startGame() {
        this.isOnGame = true;
        setting();
        // 입력받기 &&  변환 가능 판단
        boolean isEnd = false;
        while(!isEnd){
            String input = getInputNumber("숫자를 입력해주세요.");
            GameResult gameResult = judge(input);
            isEnd = processGameResult(gameResult);

        }
        boolean isReGame = getInputGameOption("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        if (isReGame) {
            startGame();
        }
        this.isOnGame = false;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void setting() {
//        this.ballCnt = 0;
//        this.strikeCnt = 0;
        number = String.valueOf((int) (Math.random() * 899) + 100);
    }

    public void manualSetting() {
        this.number = getInputNumber("숫자를 입력해주세요.");
    }

    public boolean getInputGameOption(String msg) {
        System.out.println(msg);
        String input = scanner.nextLine();
        while (!checkDigits(input, 1, 2)) {
            input = this.scanner.nextLine();
        }
        return input.equals("1") ? true : false;
    }

    // 게임 숫자 3자리수 받기
    public String getInputNumber(String msg) {
        System.out.println(msg);
        String input = scanner.nextLine();
        while (!checkDigits(input, 100, 999)) {
            input = this.scanner.nextLine();
        }
        return input;
    }

    public boolean checkNumeric(String input) {
        // 변환
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("잘못된 숫자입니다. 다시 입력해 주세요.");
            return false;
        }
        return true;
    }

    public boolean checkDigits(String input, int startNum, int endNum) {
        if(!checkNumeric(input)){
            return false;
        }
        int num = Integer.parseInt(input);
        // 자리수
        if (startNum > num || endNum < num) {
            System.out.println("범위를 벗어났습니다. 다시 입력해주세요.");
            return false;
        }
        return true;
    }

    public boolean processGameResult(GameResult gameResult) {
        if (gameResult.ballCnt != 0) {
            System.out.printf("%d볼 ", gameResult.ballCnt);
        }
        if (gameResult.strikeCnt != 0) {
            System.out.printf("%d스트라이크 ", gameResult.strikeCnt);
        }
        System.out.println();
        if (gameResult.strikeCnt != 3) {
           return false;
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        return true;

//        boolean isReGame = getInputGameOption("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
//        if (isReGame) {
//            startGame();
//        }
    }

    public GameResult judge(String ball) {
        GameResult gameResult = new GameResult();

        for (int i = 0; i < ball.length(); i++) {
            int ballResult = isBall(number, ball, i) ? 1 : 0;
            gameResult.ballCnt += ballResult;
        }

        for (int i = 0; i < ball.length(); i++) {
            int strikeResult = isStrike(number, ball, i) ? 1 : 0;
            gameResult.strikeCnt += strikeResult;
        }

        return gameResult;
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
