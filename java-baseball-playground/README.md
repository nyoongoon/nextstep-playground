## [NEXTSTEP 플레이그라운드의 미션 진행 과정](https://github.com/next-step/nextstep-docs/blob/master/playground/README.md)

---
## 학습 효과를 높이기 위해 추천하는 미션 진행 방법

---
1. 피드백 강의 전까지 미션 진행 
> 피드백 강의 전까지 혼자 힘으로 미션 진행. 미션을 진행하면서 하나의 작업이 끝날 때 마다 add, commit
> 예를 들어 다음 숫자 야구 게임의 경우 0, 1, 2단계까지 구현을 완료한 후 push

![mission baseball](https://raw.githubusercontent.com/next-step/nextstep-docs/master/playground/images/mission_baseball.png)

---
2. 피드백 앞 단계까지 미션 구현을 완료한 후 피드백 강의를 학습한다.

---
3. Git 브랜치를 master 또는 main으로 변경한 후 피드백을 반영하기 위한 새로운 브랜치를 생성한 후 처음부터 다시 미션 구현을 도전한다.

```
git branch -a // 모든 로컬 브랜치 확인
git checkout master // 기본 브랜치가 master인 경우
git checkout main // 기본 브랜치가 main인 경우

git checkout -b 브랜치이름
ex) git checkout -b apply-feedback
```


# 숫자야구게임 피드백
## 테스트 주도 개발로 구현하기
- 메소드 분리, 클래스 설계에 대한 학습
- 단위테스트와는 다른점은 -> TDD에는 리팩토링이라는 사이클이 항상 포함되어 있음! 
- TDD란 프로그래밍 의사결정과 피드백 사이의 간극을 의식하고 이를 제어하는 기술
- TDD의 아이러니 중 하나는 테스트 기술이 아니라는점. TDD는 분석기술이며 설계기술이기도 하다.
## TDD하는 이유
- 디버깅 시간 줄여줌
- 동작하는 문서 역할을 함
- 변화에 대한 두려움 줄여줌.
## 사이클
- Test fails : 실패하는 테스트를 구현한다.
- Test Passes : 테스트가 성공하도록 코드를 구현한다
- Refactor : 프로덕션 코드와 테스트코드를 리팩토링한다 
## TDD 원칙
- 원칙 1 : 실패하는 단위 테스트를 작성할 때까지 프로덕션 코드를 작성하지 않는다
- 원칙 2 : 컴파일은 실패하지 않으면서 실행이 실패하는 정도로만 단위 테스트를 작성한다
- 원칙 3 : 현재 실패하는 테스트를 통과할 정도로만 실제 코드를 작성한다. 
## 단위테스트, TDD를 시작할 때의 감정 상태
- 어디서, 어떻게 시작해야할지 모르겠다. 막막함. 
## 도메인 지식, 객체 설계 경험이 있는 경우
- 요구사항 분석을 통해 대략적인 설계 -> 객체 추출
- UI, DB 등과 의존관계를 가지지 않는 핵심 도메인 영역을 집중 설계 
### 1차적으로 도메인 로직을 테스트하는 것에 집중
![](/img/img.png)
- -> 뷰와 컨트롤러를 배제하고, 도메인영역(서비스)을 설계한 후, 이 부분에 대한 단위테스트를 진행 (우선적으로)
- 대략적인 도메인 설계 
![](/img/img_1.png)
- -> 랜덤값 생성은 테스트하기 힘든 영역이므로 분리하는것이 필요
- -> 테스트 용이한 영역과 테스트 힘든 영역을 분리하는것이 중요 역량 
## 객체 설계 경험이 없는 경우
### 1. 구현할 기능 목록 작성하기
- 구현할 기능 목록을 작성한 후에 TDD로 도전
- 기능 목록을 작성하는 것도 역량이 필요한 것 아닌가?
- 역량도 중요하지만 연습이 필요하다.. 
### 2. 그래도 막막하다면
- 단위 테스트도 없고, TDD도 아니고, 객체 설계도 하지 않고, 기능 목록을 분리하지도 않고 지금까지 익숙한 방식으로 일단 구현
- 구현하려는 프로그래밍의 도메인 지식을 쌓는다. -> 도메인 지식이 쌓이면 TodoList(기능목록)작성하는 것이 수월해짐
- 구현한 모든 코드를 버린다. 
- 구현할 기능 목록 작성 또는 간단한 도메인 설계
- 기능 목록 중 가장 만만한 녀석부터 TDD 구현 시작
- 복잡도가 높아져 리팩토링하기 힘든 상태가 되면 버린다
- 다시 도전
- **-> 아무것도 없는 상태에서 새롭게 구현하는 것보다 레거시 코드가 있는 상태에 리팩토링하는 것이 몇 배 더 어렵다.**

### 기능목록
- 기능목록을 작성한 후 테스트 가능부분 찾아 tdd 도전
- 1~9 숫자 중 랜덤으로 3개 값을 구한다
- 사용자로부터 입력받은 3개 숫자 예외 처리
- 1~9 숫자인가?
- 중복값이 있는가?
- 3자리인가?
- 위치와 숫자값이 같은 경우 - 스트라이트
- 위치는 다른데 숫자값이 같은 경우 - 볼 
- 숫자값이 다른 경우 낫싱 
- 사용자가 입력한 값에 대한 실행결과를 구한다

### 1단계 - Util 성격의 기능이 TDD로 도전하기 좋음
- 사용자로부터 입력받은 3개 숫자 예외 처리
- 1~9 숫자인가?
- 중복값이 있는가?
- 3자리인가?
```java
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
```
```java
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
```
### 2단계 - 테스트 가능한 부분에 대해 TDD로 도전
- 위치와 숫자값이 같은 경우 - 스트라이트
- 위치는 다른데 숫자값이 같은 경우 - 볼
- 숫자값이 다른 경우 낫싱 
- -> 랜덤, 데이터베이스, 날짜, UI가 제외된 부분을 다음으로 도전해보기
- --> 위의 기능을 **랜덤값하고 별개로** 해서 작성 해보기
- -> 랜덤값을 컴퓨터가 만들었다는 것은 일단 가정(랜덤기능제외)하고 -> 인풋아웃풋 테스트 해보기
- 큰 기능을 바로 테스트 및 구현하려고 하면 어려움 -> 작은 단위로 쪼개기
- PlayResult result = play(Arrays.asList(1,2,3), Arrays.asList(4,5,6)) 
- -> 위의 기능은 핵심 기능이므로 바로 구현하려고 하면 어려움..
- -> 한 번에 만드려고하면 프로덕션 코드가 많고 리팩토링하기 어려워
#### 작게 쪼개서 구현해보기
- 예를들어 123 /456 비교 시
- -> 먼저 1과 4만 비교하는 기능
- -> 어떻게 낫싱, 볼, 스트라이크 비교할 것인가? 35분 --> 숫자와 위치값이 같이 보내져야함!
```java
//tdd -> 1
public class BallTest {
    @Test
    void nothing(){
        Ball com = new Ball(1, 4); 
        assertThat(com.play(new Ball(2, 5))).isEqualTo(BallStatus.NOTHING);
    }
    // 위의 메소드 작성 후 작성되지 못한 클래스 생성하며서 컴파일에러 우선 처리
}
```
```java
// 초기에 코드중복은 많이 일어남 // -> 테스트를 통과시킨 후 리팩토링하면서 테스트코드 중복도 제거한다.
public class BallTest {
    @Test
    void ball() {
        Ball com = new Ball(1, 4);
        BallStatus status = com.play(new Ball(2, 4));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() {
        Ball com = new Ball(1, 4);
        BallStatus status = com.play(new Ball(2, 5));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
// 리팩토링
public class BallTest {
    Ball com;

    @BeforeEach
    void setUp(){
        com = new Ball(1, 4);
    }
    @Test
    void ball() {
        BallStatus status = com.play(new Ball(2, 4));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() {
        BallStatus status = com.play(new Ball(2, 5));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
```
```java
public BallStatus play(Ball ball) {
        //if (ballNo == ball.ballNo) { -> 객체 직접 접근 좋지 않으므로 리팩토링
    if (ball.matchBallNo(ballNo)) { // 객체의 메시지를 보내는 생각을 해야함..
        return BallStatus.BALL;
    }
    return BallStatus.NOTHING;
}

private boolean matchBallNo(int ballNo) {
    return this.ballNo == ballNo;
}
// 리팩토링
public BallStatus play(Ball ball) { // 처음에 List컬렉션으로 개발을 시작했다면 이런 형식으로 개발하기 어려웠을 것!
    if (this.equals(ball)) { // 객체끼리 비교 -> 객체지향적인 사고임 //equalsAndHashCode자동생성
        return BallStatus.STRIKE;
    }
    //if (ballNo == ball.ballNo) {
    if (ball.matchBallNo(ballNo)) { // 객체의 메시지를 보내는 생각을 해야함..
        return BallStatus.BALL;
    }
    return BallStatus.NOTHING;
}
```
- 조금씩 난이도를 높혀가면서 구현 -> Ball 객체의 3개를 갖는 테스트 구현
- com: 123 / user 1, 4 ->nothing
- com: 123 / user 1, 2 ->ball
- com: 123 / user 1, 1 ->strike

```java 
//Balls에 대한 테스트
public class BallsTest {
    @Test
    void nothing(){
        Balls answers = new Balls(Arrays.asList(1, 2, 3)); // 컴퓨터의 공 3개
        BallStatus status = answers.play(new Ball(1, 4));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
        
    }
}
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
```
- Balls.play(list) 구현하기
```java
 @Test
void play() {
    Balls answer = new Balls(Arrays.asList(1, 2, 3));
    PlayResult result = answer.play(Arrays.asList(1, 2, 3));
    assertThat(result.getStrike()).isEqualTo(0);
    assertThat(result.getBall()).isEqualTo(0);
}
```
```java
public PlayResult play(List<Integer> balls) {
    Balls userBalls = new Balls(balls);
    PlayResult result = new PlayResult();
    for(Ball answer : answers){
        BallStatus status = userBalls.play(answer);
        result.report(status); // 메시지 보내기..
    }
    return result;
}
```
```java
public class PlayResult {
    private int strike;
    private int ball;

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }

    public void report(BallStatus status) {
        // 메시지 보내기 형식으로 개발하기..
        if (status.isStrike()) {
            this.strike += 1;
        }
        if(status.isBall()){
            this.ball += 1;
        }
    }
}
```
```java
@Test
void play_3strike() {
    Balls answer = new Balls(Arrays.asList(1, 2, 3));
    PlayResult result = answer.play(Arrays.asList(1, 2, 3));
    assertThat(result.getStrike()).isEqualTo(3);
    assertThat(result.getBall()).isEqualTo(0);
    assertThat(result.isGameEnd()).isTrue(); // 항상 메시지 보내는 개념으로 생각하기!
}
```

#### cf) 객체에 메시지 보내기 ?
- 항상 객체에게 메시지를 보내는 방식으로 개발!!(절차지향적으로 개발하지 말기)
- -> 항상 객체가 갖고 있는 상태 데이터를 직접 접근하거나 get을 통해 접근을 지양하기..
- -> 메시지를 보내서 상태를 갖고 있는 객체가 일을 하게 만들기..

#### cf) 인터페이스 ?
- 인터페이스는 변경 가능성이나 사용여지가 있을 때 생성하는 것이 좋다 -> 너무 남발될 수 있음
#### cf) 테스트 코드 접근 제어자 ?
- 메소드를 잘게 쪼개서 private으로 많이 만드는 것은 좋다.
- 일반적으로 private 메소드는 public 메소드에 포함되므로 public 메소드로 테스트 하면 됨
- 테스트가 필요한 private 메소드인 경우 default 로 주어서 테스트 만들기 -> 테스트 코드는 같은 패키지임
#### cf) 컬렉션 변수명
- balls를 ballSet으로 변경하면 어떨까?
- -> 만약에 타입을 List로 변경해야하는 상황이라면? -> 범용적인 변수명 사용을 지향..!
#### cf) 이늄 + 인터페이스
- 이늄의 로직을 인터페이스로 만들 수 있음
- -> if문 생성을 줄일 수 있음..
