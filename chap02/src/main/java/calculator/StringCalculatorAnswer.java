package calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculatorAnswer {
    public int add(String input) {
        if (StringUtils.isEmpty(input)) return 0;
        return sum(toInts(split(input)));
    }

    private String[] split(String input) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return input.split("[,:]");
    }

    private int[] toInts(String[] values) {
        return Arrays.stream(values).mapToInt(i -> {
            int converted = Integer.parseInt(i);
            if (converted < 0) {
                throw new RuntimeException();
            }
            return converted;
        }).toArray();
    }

    private int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }

}
