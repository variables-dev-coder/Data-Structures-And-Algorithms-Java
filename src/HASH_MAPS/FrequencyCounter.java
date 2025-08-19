package HASH_MAPS;



/*
Problem 1: Count Frequency of Elements
Given an array of integers, count the frequency of each element.
Example
Input:  arr = [1, 2, 2, 3, 1, 4, 2]
Output: {1=2, 2=3, 3=1, 4=1}
Solution using HashMap
We use a HashMap<Integer, Integer> where:
Key = element
Value = frequency count
Steps
Create an empty HashMap.
Traverse the array.
If element is not in map, add it with count 1.
If element is already in map, increase its count by 1.
Print the map.
 */


import java.util.HashMap;

public class FrequencyCounter {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 1, 4, 2};

        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        System.out.println(freqMap);
    }
}

// {1=2, 2=3, 3=1, 4=1}