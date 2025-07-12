package com.ivanskyi.sbfe.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.Random;

@Slf4j
@Service
public class AuthorService {

    private static final Random RANDOM = new Random();
    private static final int RETRY_CHANCE_BOUND = 3;
    private static final String AUTHOR_NAME_PREFIX = "Author_";

    @Retryable(
            value = RuntimeException.class,
            maxAttempts = 3,
            backoff = @Backoff(delay = 1000)
    )
    public String generateRandomAuthorName() {
        if (shouldFail()) {
            log.warn("Retrying author generation...");
            throw new RuntimeException("Generation failure");
        }

        String authorName = AUTHOR_NAME_PREFIX + System.currentTimeMillis();
        log.info("Generated author: {}", authorName);
        return authorName;
    }

    @Recover
    public String recover(RuntimeException e) {
        log.error("Author generation failed after retries. Using fallback.", e);
        return "Fallback_Author";
    }

    private boolean shouldFail() {
        return RANDOM.nextInt(RETRY_CHANCE_BOUND) != 0;
    }
}
