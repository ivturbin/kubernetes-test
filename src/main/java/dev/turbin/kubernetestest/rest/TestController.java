package dev.turbin.kubernetestest.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class TestController {

    @Value("${delay:10}")
    private int delay;

    @GetMapping("/test1")
    public void test1() {
        try {
            log.info("Delay started");
            for (int i = 0; i < delay; i++) {
                Thread.sleep(TimeUnit.SECONDS.toMillis(1));
                log.debug("{}", i+1);
            }
            log.info("Delay ended");
        } catch (InterruptedException e) {
            log.error("Delay error: ", e);
            throw new RuntimeException(e);
        }
    }
}
