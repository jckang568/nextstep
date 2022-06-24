package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {
    StringCalculator stringCalculator;

    String inputValue;

    @BeforeEach
    void setup() {
        stringCalculator = new StringCalculator();
        inputValue = "//;\n1;2;3";
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
        /* given */
        final int givenSize = 3;
        final int givenFirstEl = 1;
        final int givenSecondEl = 2;
        final int givenThirdEl = 3;

        /* when */
        List<Integer> list = stringCalculator.getIntegerList("1;2;3",";");

        /* then */
        assertEquals(list.size(), givenSize);
        assertEquals(list.get(0), givenFirstEl);
        assertEquals(list.get(1), givenSecondEl);
        assertEquals(list.get(2), givenThirdEl);
    }
}