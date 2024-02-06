package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BaseBallGameTest {
    BaseBallGame baseBallGame;
    OutputStream out;
    @BeforeEach
    void init(){
        baseBallGame = new BaseBallGame();
        baseBallGame.setting();

        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

//        assertThat(out.toString()).contains("2스트라이크","2볼 1스트라이크", "3스트라이크");
    }

    @Test
    @DisplayName("숫자 랜덤 추가")
    void test0(){
        assertThat(baseBallGame.number.length()).isEqualTo(3);
    }

    @Test
    @DisplayName("숫자 직접 추가")
    void test1(){
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

    }
    @Test
    @DisplayName("숫자 직접 추가 - 잘못 입력")
    void test1_2(){

    }

    void input(){

    }


    @Test
    @DisplayName("모두 틀림")
    void test2(){

    }
    @Test
    @DisplayName("하나 맞음")
    void test3(){

    }
    @Test
    @DisplayName("두개 맞음")
    void test4(){

    }
    @Test
    @DisplayName("다 맞음")
    void test5(){

    }
}