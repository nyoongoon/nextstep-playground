package baseball;

import java.util.Scanner;

public class BaseBallGame {
    Scanner scanner = new Scanner(System.in);
    String number;
    public void setting(){
        int n = (int)(Math.random() * 899) + 100;
        number = String.valueOf(n);
    }
    public void manualSetting(){
        System.out.println("숫자를 입력해주세요.");
        // 입력받기 &&  변환 가능 판단
        String input = scanner.nextLine();
        while(!isDigitString(input)){
            System.out.println("숫자가 아닙니다. 다시 입력해주세요.");
            input = scanner.nextLine();
        }



        // 변환

        // 자리수



//        while(number == null){
//            System.out.println("숫자를 입력해주세요.");
//        }
//        while(str.length() != 3){
//            System.out.println("올바른 숫자를 입력해주세요.");
//            str = scanner.nextLine();
//        }
        number = str;
    }

    public boolean isDigitString(String input){
        boolean result = false;
        for (int i = 0; i < input.length(); i++) {
            result = isDigitChar();
            char c = input.charAt(i);
            if(Character.isDigit(c)){

            }
        }
        return
    }


}
