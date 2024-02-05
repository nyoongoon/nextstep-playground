package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void test1() {
        String target = "1,2";
        String[] result = target.split(",");
        assertThat(result).contains("1", "2");
        assertThat(result).containsExactly("1", "2");
        target = "1";
        result = target.split(",");
        assertThat(result).contains("1");
    }

    @Test
    void test2() {
        String target = "(1,2)";
        String result = target.substring(1, target.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 특정문자 가져오기")
    void test3_1() throws StringIndexOutOfBoundsException {
        String target = "abc";
        assertThat(target.charAt(0)).isEqualTo('a');
        assertThat(target.charAt(1)).isEqualTo('b');
        assertThat(target.charAt(2)).isEqualTo('c');
        assertThatThrownBy(() -> {
            target.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}


