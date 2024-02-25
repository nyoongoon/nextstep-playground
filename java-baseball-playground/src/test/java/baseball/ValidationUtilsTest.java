package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ValidationUtilsTest {
    @Test
    void 야구숫자_1_9_검증(){
        // 인풋 아웃풋을 먼저 정하기
        // 먼저 테스트코드 작성하고 alt+enter로 클래스 만들기
        // 경계값을 가지고 판단
        assertThat(ValidationUtils.validNo(9)).isTrue();
        assertThat(ValidationUtils.validNo(1)).isTrue();
        // 실패하는 케이스 찾기
        assertThat(ValidationUtils.validNo(0)).isFalse(); //--> 리팩토링
        assertThat(ValidationUtils.validNo(10)).isFalse();
        // 커밋은 하나의 테스트 코드 작성 후 기능 구현 및 리팩토링까지 완료 후 커밋하기..
    }
}
