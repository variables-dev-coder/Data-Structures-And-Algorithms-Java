package revision3;

import java.util.*;

class WordSearchII {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    public static List<String> findWords(char[][] board, String[] words) {

        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, result);
            }
        }

        return result;
    }

    private static void dfs(char[][] board, int i, int j, TrieNode node, List<String> result) {

        char c = board[i][j];

        if (c == '#' || node.children[c - 'a'] == null) return;

        node = node.children[c - 'a'];

        if (node.word != null) {
            result.add(node.word);
            node.word = null; // avoid duplicate
        }

        board[i][j] = '#';

        if (i > 0) dfs(board, i - 1, j, node, result);
        if (j > 0) dfs(board, i, j - 1, node, result);
        if (i < board.length - 1) dfs(board, i + 1, j, node, result);
        if (j < board[0].length - 1) dfs(board, i, j + 1, node, result);

        board[i][j] = c;
    }

    private static TrieNode buildTrie(String[] words) {

        TrieNode root = new TrieNode();

        for (String word : words) {

            TrieNode node = root;

            for (char c : word.toCharArray()) {

                int idx = c - 'a';

                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }

                node = node.children[idx];
            }

            node.word = word;
        }

        return root;
    }

    public static void main(String[] args) {

        char[][] board = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };

        String[] words = {"oath","pea","eat","rain"};

        List<String> result = findWords(board, words);

        System.out.println(result);
    }
}
