package Arrays.DSA_Arrays;


//  Arrays
//  An array is a data structure used to store multiple elements.


public class LowestValue_1 {
    public static void main(String[] args) {
        int[] my_array = {10, 14, 4, 7, 9,1, 34};
        int minVal = my_array[0];  //  Step 1: Assume the first element is the minimum

        for (int i : my_array) {   // Step 2: Loop through each element
            if (i < minVal) {      // Step 3: Compare current num with min
                minVal = i;        // Step 4: If smaller, update min
            }
        }
        System.out.println("Lowest Value: " + minVal);    // Step 5: Output the result
    }
}


/*
Algorithm: Find The Lowest Value in an Array

How it works:

1. Go through the values in the array one by one.
2. Check if the current value is the lowest so far, and if it is, store it.
3. After looking at all the values, the stored value will be the lowest of all values in the array.

Implementation:

1. Create a variable 'minVal' and set it equal to the first value of the array.
2. Go through every element in the array.
3. If the current element has a lower value than 'minVal', update 'minVal' to this value.
4. After looking at all the elements in the array, the 'minVal' variable now contains the lowest value.


Variable 'minVal' = array[0]
For each element in the array
    If current element < minVal
        minVal = current element

Note: The two step-by-step descriptions of the algorithm we have written above can be called 'pseudocode'.
      Pseudocode is a description of what a program does, using language that is something between human
      language and a programming language.

 */