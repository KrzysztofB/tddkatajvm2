package my.interview;

//import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

public class WordCountTest {

    WordCount wc = new WordCount();

    @ParameterizedTest
    @MethodSource("implementations")
    void emptyReturnsZero(Function<String, Map<String, Long>> wordCount) {
     
        // when:
        Map<String, Long> result = wordCount.apply("");
        assertThat(result).isEmpty();
    }

    @ParameterizedTest
    @MethodSource("implementations")
    void oneWord(Function<String, Map<String, Long>> wordCount) {
     
        // when:
        Map<String, Long> result = wordCount.apply("  something  ");
        assertThat(result)
                .hasSize(1)
                .containsEntry("something", 1L);
    }

    @ParameterizedTest
    @MethodSource("implementations")
    void more(Function<String, Map<String, Long>> wordCount) {
        // when:
        Map<String, Long> result = wordCount.apply(
                "When you think you can or you think you can't,you're right   ");
        assertThat(result)
                .hasSize(7)
                .containsEntry("When", 1L)
                .containsEntry("you", 4L)
                .containsEntry("think", 2L)
                .containsEntry("can't,you're", 1L);
    }

    private static Stream<Function<String, Map<String, Long>>> implementations(){
        return WordCount.implementations().stream();
    }
}
