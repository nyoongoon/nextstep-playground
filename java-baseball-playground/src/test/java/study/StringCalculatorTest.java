package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class StringCalculatorTest {

    String[] values;

    @BeforeEach
    void setUp() {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        values = value.split(" ");
        for(String s : values){
            System.out.print(s + " ");
        }
    }
    @Test
    @DisplayName("문자열 사칙연산")
    public void test1(){

    }
}
