package com.epam.training.ekaterina_sycheva.java_basics.decrementing_carousel_with_limit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CodeComplianceTest {

    @Test
    void testInheritance() {
        assertEquals(DecrementingCarousel.class, DecrementingCarouselWithLimitedRun.class.getSuperclass());
    }
}
