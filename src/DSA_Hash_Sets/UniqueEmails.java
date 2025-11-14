package DSA_Hash_Sets;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmails {
    /**
     * Problem: Count unique email addresses after processing rules
     * Concept: Process each email according to rules, store in HashSet for uniqueness
     * Time: O(n * m), Space: O(n)
     */
    public static int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();

        for (String email : emails) {
            String[] parts = email.split("@");
            String local = parts[0];
            String domain = parts[1];

            // Remove everything after '+'
            local = local.split("\\+")[0];
            // Remove all '.'
            local = local.replace(".", "");

            uniqueEmails.add(local + "@" + domain);
        }

        return uniqueEmails.size();
    }

    public static void main(String[] args) {
        String[] emails = {
                "test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"
        };

        System.out.println("Unique Email Addresses:");
        System.out.println("Input: " + java.util.Arrays.toString(emails));
        System.out.println("Output: " + numUniqueEmails(emails));
        System.out.println("Concept: String processing + HashSet for automatic deduplication");
        System.out.println();
    }
}

/*
Unique Email Addresses:
Input: [test.email+alex@leetcode.com, test.e.mail+bob.cathy@leetcode.com, testemail+david@lee.tcode.com]
Output: 2
Concept: String processing + HashSet for automatic deduplication

Key Concept: Process strings according to rules, then rely on HashSet's automatic deduplication.
 */