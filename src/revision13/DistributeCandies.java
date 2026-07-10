package revision13;

import java.util.HashSet;

public class DistributeCandies {

    public static int distribute(int[] candyType){

        HashSet<Integer> set = new HashSet<>();

        for(int candy : candyType)
            set.add(candy);

        return Math.min(set.size(),
                candyType.length/2);
    }

    public static void main(String[] args){

        int[] candies = {1,1,2,2,3,3};

        System.out.println(distribute(candies));
    }
}
