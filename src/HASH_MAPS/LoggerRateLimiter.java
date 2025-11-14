package HASH_MAPS;

import java.util.*;

public class LoggerRateLimiter {
    /**
     * Problem: Design logger that prints message only if not printed in last 10 seconds
     * Concept: Use HashMap to store message->timestamp mapping
     * Time: O(1), Space: O(n)
     */
    static class Logger {
        private Map<String, Integer> messageTimestamps;

        public Logger() {
            messageTimestamps = new HashMap<>();
        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            // If message not seen before, or seen more than 10 seconds ago
            if (!messageTimestamps.containsKey(message) ||
                    timestamp - messageTimestamps.get(message) >= 10) {
                messageTimestamps.put(message, timestamp);
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Logger logger = new Logger();

        System.out.println("=== Logger Rate Limiter ===");
        System.out.println("Timestamp 1, \"foo\": " + logger.shouldPrintMessage(1, "foo")); // true
        System.out.println("Timestamp 2, \"bar\": " + logger.shouldPrintMessage(2, "bar")); // true
        System.out.println("Timestamp 3, \"foo\": " + logger.shouldPrintMessage(3, "foo")); // false
        System.out.println("Timestamp 11, \"foo\": " + logger.shouldPrintMessage(11, "foo")); // true
        System.out.println("Concept: Store timestamps and check time difference");
        System.out.println();
    }
}

/*
=== Logger Rate Limiter ===
Timestamp 1, "foo": true
Timestamp 2, "bar": true
Timestamp 3, "foo": false
Timestamp 11, "foo": true
Concept: Store timestamps and check time difference

Logger Rate Limiter
Concept Used: Timestamp Storage

Key Concept: Store timestamps of messages and check if enough time has passed since last print.

 */
