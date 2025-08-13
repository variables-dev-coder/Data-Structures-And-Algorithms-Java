package Queue.PriorityQueue;


/*
Problem Statement
Given a string s, rearrange the characters of s so that no two adjacent characters are the same.
Return any possible rearrangement of s or return an empty string "" if not possible.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {
    public static String reorganizeString(String s) {
        // Step 1: Count frequencies
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Max Heap based on frequency
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(freqMap.entrySet());

        StringBuilder result = new StringBuilder();
        Map.Entry<Character, Integer> prev = null;

        // Step 3: Greedy placement
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> current = maxHeap.poll();
            result.append(current.getKey());

            // Reduce frequency
            current.setValue(current.getValue() - 1);

            // If previous character still has count, push it back
            if (prev != null && prev.getValue() > 0) {
                maxHeap.offer(prev);
            }

            // Mark current as previous for next round
            prev = current;
        }

        // Step 4: Check if result is valid
        String resStr = result.toString();
        for (int i = 1; i < resStr.length(); i++) {
            if (resStr.charAt(i) == resStr.charAt(i - 1)) {
                return ""; // Not possible
            }
        }

        return resStr;
    }

    public static void main(String[] args) {
        System.out.println(reorganizeString("aab"));   // Output: "aba"
        System.out.println(reorganizeString("aaab"));  // Output: ""
    }
}

// aba
// aba

/*

Dry Run (Example: "aab")
Frequencies: {a=2, b=1}
Max Heap: [(a,2), (b,1)]
Step 1: Take a → result = "a", remaining (a,1)
Step 2: Take b → result = "ab", remaining (b,0)
Step 3: Push back (a,1) → Take a → result = "aba"

Logic Explanation
We want to rearrange characters so no two adjacent characters are the same.
This is a frequency-based greedy problem, and a Max Heap is perfect for it.

Steps
1.Count frequency of each character.
2.Push into a max heap based on frequency (most frequent first).
3.While the heap has characters:
    Pop the top character (most frequent).
    Append it to result.
    Temporarily store the previously used character (because we can't use it again immediately).
    Reduce its frequency and push back if still available.
4.If at the end any two same characters are adjacent → not possible → return "".


ex
i/p s = "aab"
o/p "aba"

i/p s = "aab"
o/p ""

 */