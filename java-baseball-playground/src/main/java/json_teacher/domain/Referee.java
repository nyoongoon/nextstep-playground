package json_teacher.domain;

import java.util.List;

public class Referee {
    public String compare(List<Integer> computer, List<Integer> player) {
        final Jugment jugment = new Jugment();
        int correctCount = jugment.correctCount(computer, player);

        int strike = 0;
        for (int placeIndex = 0; placeIndex < player.size(); placeIndex++) {
            if (jugment.hasPlace(computer, placeIndex, player.get(placeIndex))) {
                strike++;
            }
        }
        int ball = correctCount - strike;

        if(correctCount == 0){
            return "아웃";
        }

        return ball + " 볼 " + strike + " 스트라이크";
    }
}
