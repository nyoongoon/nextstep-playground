package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> answers;

    public Balls(List<Integer> balls) {
        this.answers = mapBall(balls);
    }

    //인스턴스변수에 의존하지 않으므로 스태틱으로
    private static List<Ball> mapBall(List<Integer> answers) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            balls.add(new Ball(i + 1, answers.get(i)));
        }
        return balls;
    }

    public PlayResult play(List<Integer> balls) {
        Balls userBalls = new Balls(balls);
        PlayResult result = new PlayResult();
        for(Ball answer : answers){
            BallStatus status = userBalls.play(answer);
            result.report(status); // 메시지 보내기..
        }
        return result;
    }

    public BallStatus play(Ball userBall) {
//        return BallStatus.NOTHING;
        return answers.stream()
                .map(answer -> answer.play(userBall))
                // Enum도 인스턴스이므로 메시지를 전달하는 방식이 더 좋음
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING); // 함수형으로 작성
    }
}
