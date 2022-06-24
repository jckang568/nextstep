package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*
    요구사항
    문자열 계산기의 요구사항은 전달하는 문자를 구분자로 분리한 후 각 숫자의 합을 구해 반환해야 한다.
    1. 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
    (예. " " => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6)
    2. 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를
    커스텀 구분자로 사용한다. 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
    3. 문자열 계산기에 음수를 전달하는 경우 RuntimeException으로 예외 처리해야 한다.
 */
public class StringCalculator {

    int add(String text) {
        return 0;
    }

    List<Integer> getIntegerList(String splitInput) {
        StringTokenizer stringTokenizer = new StringTokenizer(splitInput, ",", false);
        List<String> stringList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        while(stringTokenizer.hasMoreTokens()){
            stringList.add(stringTokenizer.nextToken());
        }
        for(int i = 0; i < stringList.size() ; i ++ ) {
            stringTokenizer = new StringTokenizer(stringList.get(i), ":", false);
            while(stringTokenizer.hasMoreTokens()){
                integerList.add(Integer.valueOf(stringTokenizer.nextToken()));
            }
        }
        return integerList;
    }


    boolean isExistCustomDelimiter(String text) {
        return Pattern.compile("^//\\D\\n.*$").matcher(text).matches();
    }

    String getCustomDelimiter(String text) {
        return text.substring(2, 3);
    }

    String getSplitInput(String input) {
        return input.substring(4, input.length());
    }

    List<Integer> getIntegerList(String splitInput, String delimiter) {
        StringTokenizer stringTokenizer = new StringTokenizer(splitInput, delimiter, false);
        List<Integer> list = new ArrayList<>();
        while(stringTokenizer.hasMoreTokens()){
            list.add(Integer.valueOf(stringTokenizer.nextToken()));
        }
        return list;
    }

    int[] arrayListToList(List<Integer> integerList) {
        return integerList.stream().mapToInt(i -> i).toArray();
    }

    int sum(int[] intList) {
        return Arrays.stream(intList).sum();
    }
}

