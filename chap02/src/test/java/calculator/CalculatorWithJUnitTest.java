package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorWithJUnitTest {
    /*
        JUnit은 다음 예제 소스와 같이 테스트 메서드에 @Test 어노테이션(Annotation)을 추가한다.
        아래와 같이 Junit 기반으로 테스트 코드를 구현하면 calculator.CalculatorWithJUnitTest 클래스가 가지는 전체 메서드를 한번에 실행할 수도 있으며,
        add(), subtract() 메서드 각각을 실행할 수도 있다. 이와 같이 각각의 테스트 메서드를 독립적으로 실행할 수 있기 때문에 현재 내가 구현하고
        있는 프로덕션 코드의 메서드만 실행해 볼 수 있다. 즉, 다른 메서드에 영향을 받지 않기 때문에 내가 현재 구현하고 있는 프로덕션 코드에 집중할 수
        있는 효과를 얻을 수 있다.
     */
    @Test
    public void add() {
        Calculator cal = new Calculator();
        System.out.println(cal.add(6, 3));
    }

    @Test
    public void subtract() {
        Calculator cal = new Calculator();
        System.out.println(cal.subtract(6, 3));
    }

    /*
        main() 메서드의 두 번째 문제점은 실행 결과를 눈으로 직접 확인해야 한다는 것이다. JUnit은 이 같은 문제점을 극복하기 위해 assertEquals()
        메서드를 제공한다. assertEquals는 static메서드라 import static으로 메서드를 import한 후 아래와 같이 구현할 수 있다.
        assertEquals() 메서드의 첫 번째 인자는 기대하는 결과 값(expected)이고, 두 번째 인자는 프로덕션 코드의 메서드를 실행한 결과 값(actual)
        이다. assertEquals() 메서드는 int, long, String 등 다양한 데이터 타입 지원이 가능하다.
        Junit의 Assertions 클래스는 assertEquals() 메서드 이외에도 결과 값이 true/false 인지를 확인할 수 있는 assertTrue(),
        assertFalse() 메서드, 결과 값이 null 유무를 판단할 수 있는 assertNull(), assertNotNull() 메서드, 배열 값이 같은지를 검증하는
        assertArrayEquals() 메서드를 제공하니 Assertions 클래스 Javadoc 문서를 참고하기 바란다.
        (최근에는 JUnit의 Assert를 사용하기보다 테스트의 의도를 더 쉽게 파악할 수 있는 기능을 제공하는 AssertJ도 많이 사용한다.)
     */
    @Test
    public void addWithAssert() {
        Calculator cal = new Calculator();
        assertEquals(8, cal.add(6, 3));
    }

    @Test
    public void subtractWithAssert() {
        Calculator cal = new Calculator();
        assertEquals(3, cal.subtract(6, 3));
    }

}
