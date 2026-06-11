package revision9;

import java.util.HashSet;

public class Intersection {
    public static void main(String[] args) {

        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();

        for(int num : nums1){
            set1.add(num);
        }

        for(int num : nums2){

            if(set1.contains(num)){
                result.add(num);
            }
        }

        System.out.println(result);
    }
}
