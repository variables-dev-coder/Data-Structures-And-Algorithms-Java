package revision11;

import java.util.Stack;

public class MaximalRectangle {

    public static int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {

            int currentHeight =
                    (i == heights.length)
                            ? 0
                            : heights[i];

            while (!stack.isEmpty()
                    && currentHeight <
                    heights[stack.peek()]) {

                int height =
                        heights[stack.pop()];

                int width;

                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width =
                            i
                                    - stack.peek()
                                    - 1;
                }

                maxArea =
                        Math.max(
                                maxArea,
                                height * width
                        );
            }

            stack.push(i);
        }

        return maxArea;
    }

    public static int maximalRectangle(
            char[][] matrix) {

        if (matrix.length == 0)
            return 0;

        int cols = matrix[0].length;

        int[] heights =
                new int[cols];

        int maxArea = 0;

        for (char[] row : matrix) {

            for (int col = 0;
                 col < cols;
                 col++) {

                if (row[col] == '1') {

                    heights[col]++;

                } else {

                    heights[col] = 0;
                }
            }

            maxArea =
                    Math.max(
                            maxArea,
                            largestRectangleArea(
                                    heights
                            )
                    );
        }

        return maxArea;
    }

    public static void main(String[] args) {

        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };

        System.out.println(
                maximalRectangle(matrix)
        );
    }
}
