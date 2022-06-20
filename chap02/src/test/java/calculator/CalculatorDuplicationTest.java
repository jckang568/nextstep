package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    개발자가 가져야 할 좋은 습관 중의 하나는 중복 코드를 제거하는 것이다. 중복 코드는 프로그래밍의 가장 큰 적 중의 하나이다. 테스트 코드 또한 많은 중복이
    발생한다. 앞에서 구현한 CalculatorWithJunitTest 클래스 또한 calculator.Calculator 인스턴스를 생성하는 부분에 중복이 발생한다. 이 중복을 다음과 같이
    제거할 수 있다.
 */
public class CalculatorDuplicationTest {
    /*
        이와 같이 중복을 제거하는 것은 자바 문법에 아무런 문제도 없다. 하지만 JUnit은 테스트를 실행하기 위한 초기화 작업을 아래와 같이 구현하는 것을
        추천하지 않는다.
     */
    /*
    private calculator.Calculator cal = new calculator.Calculator();
     */
    /*
        JUnit은 위 구현을 @BeforeEach 어노테이션을 활용해 다음과 같이 구현할 것을 추천한다.
        @BeforeEach 어노테이션을 사용하지 않고 필드(field)로 구현하는 방법 모두 각 단위 테스트를 실행할 때마다 calculator.Calculator 인스턴스를 생성
        하는 것은 같다. 이와 같이 calculator.Calculator 인스턴스를 매 테스트마다 생성하는 이유는 add() 테스트 메서드를 실행할 때 Calculator의 상태
        값이 변경되어 다음 테스트 메서드인 subtract() 테스트 메서드를 실행할 때 영향을 미칠 수 있기 때문이다. 이와 같이 테스트 메서드 간 영향을
        미칠 경우 테스트 실행 순서나 calculator.Calculator 상태 값에 따라 테스트가 성공하거나 실패할 수 있다. 그렇다면 앞의 구현 방식보다 코딩량도 더 많아
        구현 비용도 더 큰데, 왜 @BeforeEach 어노테이션을 사용하는 방식으로 구현할 것을 추천할까?
        JUnit 에는 @Runwith, @Rule 같은 어노테이션을 사용해 기능을 확장할 수 있는데, @BeforeEach 안이어야만 @Runwith, @Rule 에서
        초기화 된 객체에 접근할 수 있다는 제약사항이 있기 때문이다. 따라서 가능한 @BeforeEach 어노테이션을 사용해 테스트 메서드에 대한 초기화
        작업을 하는 것이 추후 문제가 발생할 가능성을 없앨 수 있다.
     */
    private Calculator cal;

    @BeforeEach
    public void setup() {
        cal = new Calculator();
    }

    @Test
    void addWithAssert() {
        assertEquals(8, cal.add(6, 3));
    }

    @Test
    void subtractWithAssert() {
        assertEquals(3, cal.subtract(6, 3));
    }
}


