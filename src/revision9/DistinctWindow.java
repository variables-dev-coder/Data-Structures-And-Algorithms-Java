package revision9;

import java.util.HashMap;

public class DistinctWindow {

    public static void main(String[] args) {

        int[] arr = {1,2,1,3,4,2,3};
        int k = 4;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<k;i++){
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }

        System.out.print(map.size() + " ");

        for(int i=k;i<arr.length;i++){

            int remove = arr[i-k];

            map.put(remove, map.get(remove)-1);

            if(map.get(remove)==0){
                map.remove(remove);
            }

            map.put(arr[i],
                    map.getOrDefault(arr[i],0)+1);

            System.out.print(map.size() + " ");
        }
    }
}
