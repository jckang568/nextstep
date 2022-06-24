package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
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

    @Test
    void getIntegerListDefaultTest() {
        final int givenSize = 8;
        final int givenFirstEL = 4;
        final int givenSecondEL = 6;
        final int givenThirdEL = 2;
        final int givenForthEL = 2;
        final int givenFifthEL = 1;
        final int givenSixthEL = 7;
        final int givenSeventhEL = 9;
        final int givenEighthEL = 1;

        List<Integer> list = stringCalculator.getIntegerList("4,6,2:2:1,7:9,1");

        assertEquals(list.size(), givenSize);
        assertEquals(list.get(0), givenFirstEL);
        assertEquals(list.get(1), givenSecondEL);
        assertEquals(list.get(2), givenThirdEL);
        assertEquals(list.get(3), givenForthEL);
        assertEquals(list.get(4), givenFifthEL);
        assertEquals(list.get(5), givenSixthEL);
        assertEquals(list.get(6), givenSeventhEL);
        assertEquals(list.get(7), givenEighthEL);

    }
    /*
        @Nested
        @displayName
        정리
     */

    @Test
    void test() {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher("//;\n1;2;3");
        System.out.println(matcher.find());
        System.out.println(matcher.matches());
        System.out.println("matcher.group() : " + matcher.group());
        System.out.println("matcher.group(0) : " + matcher.group(0));
        System.out.println("matcher.group(1) : " + matcher.group(1));
        System.out.println("matcher.group(2) : " + matcher.group(2));

        Matcher matcher2 = Pattern.compile("//(.)\n(.*)").matcher("//;\n1;2;3");
        System.out.println(matcher2.find());
        System.out.println(matcher2.matches());
        System.out.println("matcher2.group() : " + matcher2.group());
        System.out.println("matcher2.group(0) : " + matcher2.group(0));
        System.out.println("matcher2.group(1) : " + matcher2.group(1));
        System.out.println("matcher2.group(2) : " + matcher2.group(2));
        System.out.println("matcher2.group(3) : " + matcher2.group(3));
    }

    @Test
    void matcherTest(){
        final Matcher subMatcher = Pattern.compile("\\d+").matcher("skrf35kesruytfkwu4ty7sdfs");
        System.out.println("Found: " + subMatcher.matches());
        System.out.println("Found: " + subMatcher.find() + " - position " + subMatcher.start());
        System.out.println("Found: " + subMatcher.find() + " - position " + subMatcher.start());
        System.out.println("Found: " + subMatcher.find() + " - position " + subMatcher.start());
        System.out.println("Found: " + subMatcher.find());
        System.out.println("Found: " + subMatcher.find());
        System.out.println("Matched: " + subMatcher.matches());

        System.out.println("-----------");
        final Matcher fullMatcher = Pattern.compile("^\\w+$").matcher("skrf35kesruytfkwu4ty7sdfs");
        System.out.println("Found: " + fullMatcher.find() + " - position " + fullMatcher.start());
        System.out.println("Found: " + fullMatcher.find());
        System.out.println("Found: " + fullMatcher.find());
        System.out.println("Matched: " + fullMatcher.matches());
        System.out.println("Matched: " + fullMatcher.matches());
        System.out.println("Matched: " + fullMatcher.matches());
        System.out.println("Matched: " + fullMatcher.matches());
    }

}
