package com.vincentdao.pimtoolback;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PimToolBackApplicationTests {

    @Test
    void contextLoads() {
        boolean dummy = true;
        assertThat(dummy).isTrue();
    }
}
