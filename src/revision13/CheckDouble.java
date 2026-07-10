package revision13;

import java.util.HashSet;

public class CheckDouble {

    public static boolean check(int[] arr){

        HashSet<Integer> set = new HashSet<>();

        for(int num : arr){

            if(set.contains(num*2))
                return true;

            if(num % 2 == 0 && set.contains(num/2))
                return true;

            set.add(num);
        }

        return false;
    }

    public static void main(String[] args){

        int[] nums = {10,2,5,3};

        System.out.println(check(nums));
    }
}
