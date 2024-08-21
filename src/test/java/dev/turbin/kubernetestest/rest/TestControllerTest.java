package dev.turbin.kubernetestest.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class TestControllerTest {

    @Autowired
    private TestController testController;

    @Value("${delay:10}")
    private int delay;

    @Test
    void test1() {

        long startTime = System.nanoTime();

        // Run testing method
        testController.test1();

        long endTime = System.nanoTime();

        long durationInMillis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);

        assertTrue(durationInMillis >=  TimeUnit.SECONDS.toMillis(delay),
                "Error: method ran faster than expected");
    }
}