package revision11;

import java.util.Stack;

public class RemoveDuplicateLetters {

    public static String removeDuplicateLetters(String s) {

        int[] frequency = new int[26];

        for(char ch : s.toCharArray()) {
            frequency[ch - 'a']++;
        }

        boolean[] visited = new boolean[26];

        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()) {

            frequency[ch - 'a']--;

            if(visited[ch - 'a']) {
                continue;
            }

            while(!stack.isEmpty()
                    && stack.peek() > ch
                    && frequency[stack.peek() - 'a'] > 0) {

                visited[stack.pop() - 'a'] = false;
            }

            stack.push(ch);
            visited[ch - 'a'] = true;
        }

        StringBuilder result = new StringBuilder();

        for(char ch : stack) {
            result.append(ch);
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String s = "cbacdcbc";

        System.out.println(
                removeDuplicateLetters(s)
        );
    }
}
