package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorAnswerTest {
    private StringCalculatorAnswer stringCalculatorAnswer;

    @BeforeEach
    public void setup() {
        stringCalculatorAnswer = new StringCalculatorAnswer();
    }

    /*
        메서드 이름을 영어로 작성하는 것이 일반적이지만 테스트 메서드가 어떤 테스트인지를 명확하게 전달하기 위해 영어로 작성하기 힘들다면
        한글로 작성하는 것도 한 가지 방법이다.
     */
    @Test
    public void add_null_또는_빈문자() {
        assertEquals(0, stringCalculatorAnswer.add(null));
        assertEquals(0, stringCalculatorAnswer.add(""));
    }

    @Test
    public void add_숫자하나() {
        assertEquals(1, stringCalculatorAnswer.add("1"));
    }

    @Test
    public void add_쉼표구분자() {
        assertEquals(6, stringCalculatorAnswer.add("1,2,3"));
    }

    @Test
    public void add_쉼표_또는_콜론_구분자() {
        assertEquals(6, stringCalculatorAnswer.add("1,2:3"));
    }

    @Test
    public void add_custom_구분자() {
        assertEquals(6, stringCalculatorAnswer.add("//;\n1;2;3"));
    }

    @Test
    public void add_negative() {
        assertThrows(RuntimeException.class, () -> stringCalculatorAnswer.add("-1,2,3"));

    }

    @Test
    public void splitLimitTest() {
        String testInput = "boo:and:foo";
        String[] values = testInput.split("o", 0);
        for (String value : values) {
            System.out.println("value = " + value);
        }
    }

    @Test
    public void splitTest() {
        assertArrayEquals(new String[]{"1"}, "1".split(","));
        assertArrayEquals(new String[]{"1", "2", "3"}, "1,2,3".split(","));
    }
}
