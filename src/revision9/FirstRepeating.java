package revision9;

import java.util.HashSet;

public class FirstRepeating {
    public static void main(String[] args) {

        int[] arr = {10,5,3,4,3,5,6};

        HashSet<Integer> set = new HashSet<>();

        for(int i = arr.length - 1; i >= 0; i--){

            if(set.contains(arr[i])){
                System.out.println(arr[i]);
            }

            set.add(arr[i]);
        }
    }
}
