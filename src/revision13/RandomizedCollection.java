package revision13;

import java.util.*;

public class RandomizedCollection {

    private ArrayList<Integer> list;

    private HashMap<Integer,
            HashSet<Integer>> map;

    private Random random;

    public RandomizedCollection() {

        list = new ArrayList<>();

        map = new HashMap<>();

        random = new Random();
    }

    public boolean insert(int val) {

        boolean notPresent =
                !map.containsKey(val);

        map.putIfAbsent(
                val,
                new HashSet<>());

        map.get(val).add(list.size());

        list.add(val);

        return notPresent;
    }

    public int getRandom() {

        return list.get(
                random.nextInt(list.size())
        );
    }

    public static void main(String[] args) {

        RandomizedCollection rc =
                new RandomizedCollection();

        rc.insert(5);
        rc.insert(5);
        rc.insert(7);

        System.out.println(rc.getRandom());
    }
}
