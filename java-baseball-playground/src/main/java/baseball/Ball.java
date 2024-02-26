package baseball;

import java.util.Objects;

public class Ball {

    private final int position;
    private final int ballNo;

    public Ball(int position, int ballNo) {
        this.position = position;
        this.ballNo = ballNo;
    }

    public BallStatus play(Ball ball) {
        if (this.equals(ball)) { // 객체끼리 비교 -> 객체지향적인 사고임 //equalsAndHashCode자동생성
            return BallStatus.STRIKE;
        }
        //if (ballNo == ball.ballNo) {
        if (ball.matchBallNo(ballNo)) { // 객체의 메시지를 보내는 생각을 해야함..
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    private boolean matchBallNo(int ballNo) {
        return this.ballNo == ballNo;
    }

    @Override
    public boolean equals(Object o) { //자동생성
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && ballNo == ball.ballNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, ballNo);
    }
}
