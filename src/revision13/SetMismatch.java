package revision13;

import java.util.HashSet;

public class SetMismatch {

    public static void main(String[] args) {

        int[] nums = {1,2,2,4};

        HashSet<Integer> set = new HashSet<>();

        int duplicate = -1;

        for(int num : nums){

            if(!set.add(num))
                duplicate = num;
        }

        int missing = -1;

        for(int i=1;i<=nums.length;i++){

            if(!set.contains(i)){
                missing = i;
                break;
            }
        }

        System.out.println("Duplicate : " + duplicate);
        System.out.println("Missing   : " + missing);
    }
}
