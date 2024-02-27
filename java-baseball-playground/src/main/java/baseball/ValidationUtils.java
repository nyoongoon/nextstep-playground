package baseball;

public class ValidationUtils {
    public static final int MIN = 0; //alt+cmd+c
    public static final int MAX = 9;
    public static boolean validNo(int no) {
        if (no >= MIN && no <= MAX) {
            return true;
        }
        return false;
    }
}
