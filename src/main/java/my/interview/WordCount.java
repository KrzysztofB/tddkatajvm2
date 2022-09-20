package my.interview;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCount {

    public static List<Function<String, Map<String, Long>>> implementations() {
        return List.of(
            WordCount::count1,
            WordCount::count2,
            WordCount::count3);
    }

    /**
     * Count words in text
     * Case is important, only whitespaces are separators
     * 
     * @param text
     * @return number of words
     */
    public static Map<String, Long> count(String text) {
        return count3(text);
    }

    private static Map<String, Long> count1(String text) {
        return Arrays.stream(text.split("\\s+"))
                .filter(word -> !word.isBlank())
                .collect(Collectors.toMap(word -> word, word -> first(), (Long c1, Long c2) -> c1 + c2));

    }

    static final Long ONE = Long.valueOf(1L);

    private static Long first() {
        return ONE;
    }

    private static Map<String, Long> count2(String text) {
        return Arrays.asList(text.split("\\s+")).stream()
                .filter(word -> !word.isBlank())
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
    }

    private static Map<String, Long> count3(String text) {
        StringTokenizer tokenizer = new StringTokenizer(text);
        return Stream.iterate(tokenizer, StringTokenizer::hasMoreTokens, t -> t)
                .map(StringTokenizer::nextToken)
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
    }
}
