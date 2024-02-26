package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> balls;

    public Balls(List<Integer> answers) {
        this.balls = mapBall(answers);
    }

    //인스턴스변수에 의존하지 않으므로 스태틱으로
    private static List<Ball> mapBall(List<Integer> answers) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            balls.add(new Ball(i + 1, answers.get(i)));
        }
        return balls;
    }

    public BallStatus play(Ball userBall) {
//        return BallStatus.NOTHING;
        return balls.stream()
                .map(answer -> answer.play(userBall))
                .filter(status -> status != BallStatus.NOTHING)
                .findFirst()
                .orElse(BallStatus.NOTHING); // 함수형으로 작성
    }
}
