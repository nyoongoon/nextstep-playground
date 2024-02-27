package baseball;

public class BallNumber {
    public static final int MIN = 0; //alt+cmd+c
    public static final int MAX = 9;
    private int no;

    // 원시값 -> 객체 포장 --> 생성자에서 예외처리를 할 수 있다.
    public BallNumber(int no) {
        if (no < MIN || no > MAX) {
            throw new IllegalArgumentException("볼 숫자는 1부터 9의 값이어야 합니다.");
        }
        this.no = no;
    }
}
