package calculator;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    Junit은 @BeforEach 어노테이션을 제공해 초기화 작업을 하듯이 @AfterEach 어노테이션을 제공한다. @AfterEach 어노테이션은 메서드
    실행이 끝난 후 실행됨으로써 후처리 작업을 담당한다. @BeforeEach, @AfterEach 어노테이션 실행 순서를 확인하기 위해 다음과 같이 구현한
    코드를 실행해 보자.
 */
public class CalculatorProcedureTest {
    private Calculator cal;

    @BeforeAll
    static void setupAll(){
        System.out.println("setupAll");
    }

    @BeforeEach
    void setup() {
        cal = new Calculator();
        System.out.println("setupEach");
    }

    @AfterAll
    static void breakDownAll() {
        System.out.println("afterAll");
    }

    @AfterEach
    void breakDown(){
        System.out.println("afterEach");
    }

    @Test
    void add() {
        assertEquals(9, cal.add(6,3));
        System.out.println("add");
    }

    @Test
    void subtract() {
        assertEquals(3, cal.subtract(6,3));
        System.out.println("subtract");
    }
}
