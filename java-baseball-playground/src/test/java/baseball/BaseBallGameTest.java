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

    @Test
    @DisplayName("숫자 랜덤 추가")
    void test0() {
        baseBallGame.validateDigits(baseBallGame.number);
    }

    @Test
    @DisplayName("숫자 직접 추가")
    void test1() {
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        baseBallGame.setScanner(scanner);
        baseBallGame.manualSetting();
        assertThat(baseBallGame.number).isEqualTo(input);
    }

    @Test
    @DisplayName("숫자 직접 추가 - 숫자가 아닌 문자 입력")
    void test1_2() {
        String input = "ㄱ\n" + "321\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        baseBallGame.setScanner(new Scanner(System.in));
        baseBallGame.manualSetting();
        assertThat(baseBallGame.number).isEqualTo("321");
    }

    @Test
    @DisplayName("숫자 직접 추가 - 범위 벗어난 숫자 입력")
    void test1_3() {
        String input = "-1\n" + "1111\n" + "789";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        baseBallGame.setScanner(new Scanner(System.in));
        baseBallGame.manualSetting();
        assertThat(baseBallGame.number).isEqualTo("789");
    }


    @Test
    @DisplayName("모두 틀림")
    void test2() {

    }

    @Test
    @DisplayName("하나 맞음")
    void test3() {

    }

    @Test
    @DisplayName("두개 맞음")
    void test4() {

    }

    @Test
    @DisplayName("다 맞음")
    void test5() {

    }
}