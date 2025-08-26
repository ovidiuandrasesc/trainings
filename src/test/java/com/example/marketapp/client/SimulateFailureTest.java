package com.example.marketapp.client;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimulateFailureTest {

    @Test
    void a_random_test_that_fails() {

        assertEquals(5, 5, "fix test failure");
    }

    @Test
    void a_random_test_that_passes() {

        assertEquals(5, 5, "test test success");
    }
}
