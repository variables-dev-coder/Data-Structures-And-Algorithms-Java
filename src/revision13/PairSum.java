package revision13;

import java.util.HashSet;

public class PairSum {

    public static void pairSum(int[] nums,
                               int target){

        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){

            int complement = target - num;

            if(set.contains(complement)){

                System.out.println(
                        complement + " " + num
                );

                return;
            }

            set.add(num);
        }

        System.out.println("No Pair");
    }

    public static void main(String[] args){

        int[] nums = {2,7,11,15};

        pairSum(nums,9);
    }
}
