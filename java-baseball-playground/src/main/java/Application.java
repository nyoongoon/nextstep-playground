import baseball.BaseBallGame;

public class Application {
    public static void main(String[] args) {
        System.out.println();

        BaseBallGame baseBallGame = new BaseBallGame();
        baseBallGame.setting();
        baseBallGame.startGame();
    }
}
