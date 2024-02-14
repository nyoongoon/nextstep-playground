package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class BaseBallGameTest {
    BaseBallGame baseBallGame;
    OutputStream out;

    @BeforeEach
    void init() {
        baseBallGame = new BaseBallGame();
        baseBallGame.setting();

        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

//        assertThat(out.toString()).contains("2스트라이크","2볼 1스트라이크", "3스트라이크");
    }

    // 테스트 시 인풋처리
    private void testSetInput(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        baseBallGame.setScanner(scanner);
        baseBallGame.manualSetting();
    }

    private void testGameInput(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        baseBallGame.setScanner(scanner);
    }

    @Test
    @DisplayName("숫자 랜덤 추가")
    void test0() {
        baseBallGame.checkDigits(baseBallGame.number, 1, 999);
    }

    @Test
    @DisplayName("숫자 직접 추가")
    void test1() {
        String input = "123";
        testSetInput(input);
        assertThat(baseBallGame.number).isEqualTo(input);
    }

    @Test
    @DisplayName("숫자 직접 추가 - 숫자가 아닌 문자 입력")
    void test1_2() {
        String input = "ㄱ\n" + "321\n";
        testSetInput(input);
        assertThat(baseBallGame.number).isEqualTo("321");
    }

    @Test
    @DisplayName("숫자 직접 추가 - 범위 벗어난 숫자 입력")
    void test1_3() {
        String input = "-1\n" + "1111\n" + "789";
        testSetInput(input);
        assertThat(baseBallGame.number).isEqualTo("789");
    }

    @Test
    @DisplayName("인덱스가 다르고 같은 문자인지 판단")
    void test2_1(){
        assertThat(baseBallGame.isEqualCharExceptIdx('1', '1', 0, 2)).isTrue();
        assertThat(baseBallGame.isEqualCharExceptIdx('1', '1', 0, 0)).isFalse();
        assertThat(baseBallGame.isEqualCharExceptIdx('0', '1', 0, 2)).isFalse();
        assertThat(baseBallGame.isEqualCharExceptIdx('0', '1', 0, 0)).isFalse();
    }

    @Test
    @DisplayName("인덱스가 다르고 같은 문자가 있는지 판단")
    void test2_2(){
        assertThat(baseBallGame.isBall("123", "321", 0)).isTrue();
        assertThat(baseBallGame.isBall("123", "451", 2)).isTrue();
        assertThat(baseBallGame.isBall("123", "123", 0)).isFalse();
    }

    @Test
    @DisplayName("모두 틀림")
    void test3() {
        testSetInput("123");
        BaseBallGame.GameResult gameResult = baseBallGame.judge("456");
        assertThat(gameResult.ballCnt).isEqualTo(0);
        assertThat(gameResult.strikeCnt).isEqualTo(0);
    }

    @Test
    @DisplayName("볼만 있는 경우")
    void test3_1() {
        testSetInput("123");
        BaseBallGame.GameResult gameResult = baseBallGame.judge("345");
        assertThat(gameResult.ballCnt).isEqualTo(1);
        assertThat(gameResult.strikeCnt).isEqualTo(0);

        testSetInput("123");
        gameResult = baseBallGame.judge("341");
        assertThat(gameResult.ballCnt).isEqualTo(2);
        assertThat(gameResult.strikeCnt).isEqualTo(0);

        testSetInput("123");
        gameResult = baseBallGame.judge("312");
        assertThat(gameResult.ballCnt).isEqualTo(3);
        assertThat(gameResult.strikeCnt).isEqualTo(0);
    }

    @Test
    @DisplayName("볼, 스트라이크 둘 다 있는 경우")
    void test3_2() {
        testSetInput("123");
        BaseBallGame.GameResult gameResult = baseBallGame.judge("134");
        assertThat(gameResult.ballCnt).isEqualTo(1);
        assertThat(gameResult.strikeCnt).isEqualTo(1);

        testSetInput("123");
        gameResult = baseBallGame.judge("213");
        assertThat(gameResult.ballCnt).isEqualTo(2);
        assertThat(gameResult.strikeCnt).isEqualTo(1);
    }

    @Test
    @DisplayName("스트라이크만 있는 경우")
    void test3_3() {
        testSetInput("123");
        BaseBallGame.GameResult gameResult = baseBallGame.judge("145");
        assertThat(gameResult.ballCnt).isEqualTo(0);
        assertThat(gameResult.strikeCnt).isEqualTo(1);

        testSetInput("123");
        gameResult = baseBallGame.judge("125");
        assertThat(gameResult.ballCnt).isEqualTo(0);
        assertThat(gameResult.strikeCnt).isEqualTo(2);

        testSetInput("123");
        gameResult = baseBallGame.judge("123");
        assertThat(gameResult.ballCnt).isEqualTo(0);
        assertThat(gameResult.strikeCnt).isEqualTo(3);
    }

    @Test
    @DisplayName("재시작 여부")
    void test4() {
        testSetInput("123");
        testGameInput("123\n2");
        baseBallGame.startGame();
        assertThat(baseBallGame.isOnGame).isFalse();
        testSetInput("123");
        testGameInput("321\n222\n123\n2");
        baseBallGame.startGame();
        assertThat(baseBallGame.isOnGame).isFalse();
    }
}