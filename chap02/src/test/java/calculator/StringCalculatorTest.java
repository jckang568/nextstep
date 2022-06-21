package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {
    StringCalculator stringCalculator;

    String inputValue;

    @BeforeEach
    void setup() {
        stringCalculator = new StringCalculator();
        inputValue = "//;\\n1;2;3";
    }

    @Test
    void customDelimiterTest() {
        assertTrue(stringCalculator.isExistCustomDelimiter(inputValue));
        assertEquals(";", stringCalculator.getCustomDelimiter(inputValue));
        assertEquals("1;2;3", stringCalculator.getSplitInput(inputValue));
    }

    /*
        StringCalculator의 getIntegerList를 단위테스트 하고 싶은데 어떻게 짜야할지 모르겠음.
     */
    @Test
    void getIntegerListTest() {
        List<Integer> list = new ArrayList<>();
        assertEquals(list, stringCalculator.getIntegerList("1;2;3",";"));
    }
}