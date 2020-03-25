package org.codingdojo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("JUnit 5 Example")
public class ExampleTest {
    @Test
    public void shouldPass(){
        assertThat(42).isEqualTo(42);
    }
}
