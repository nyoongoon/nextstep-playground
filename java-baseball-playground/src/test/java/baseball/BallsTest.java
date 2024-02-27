package baseball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BallsTest {
    @Test
    void play_nothing() {
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        PlayResult result = answer.play(Arrays.asList(4, 5, 6));
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    void play_1strike_1ball() {
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        PlayResult result = answer.play(Arrays.asList(1, 4, 2));
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    void play_3strike() {
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        PlayResult result = answer.play(Arrays.asList(1, 2, 3));
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.isGameEnd()).isTrue(); // 항상 메시지 보내는 개념으로 생각하기!
    }

    @Test
    void strike() {
        Balls answers = new Balls(Arrays.asList(1, 2, 3)); // 컴퓨터의 공 3개
        BallStatus status = answers.play(new Ball(1, 1));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball() {
        Balls answers = new Balls(Arrays.asList(1, 2, 3)); // 컴퓨터의 공 3개
        BallStatus status = answers.play(new Ball(1, 2));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() {
        Balls answers = new Balls(Arrays.asList(1, 2, 3)); // 컴퓨터의 공 3개
        BallStatus status = answers.play(new Ball(1, 4));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
