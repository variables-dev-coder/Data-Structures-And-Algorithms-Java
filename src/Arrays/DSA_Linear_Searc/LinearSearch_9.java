package Arrays.DSA_Linear_Searc;


// Find All Indices of a Target Element in an Array
// Given an array and a target value, return a list of all indices where the target element is found.

import java.util.ArrayList;
import java.util.List;

public class LinearSearch_9 {
    public static List<Integer> findAllIndices(int[] arr, int target) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                result.add(i);  // Add index to result
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 1, 8, 3, 3};
        int target = 3;

        List<Integer> indices = findAllIndices(arr, target);

        if (indices.isEmpty())
            System.out.println("Element not found!");
        else
            System.out.println("Indices: " + indices);
    }
}
