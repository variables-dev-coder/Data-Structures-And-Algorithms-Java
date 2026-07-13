package revision13;

import java.util.*;

public class RandomizedSet {

    private HashMap<Integer, Integer> map;
    private ArrayList<Integer> list;
    private Random random;

    public RandomizedSet() {

        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {

        if (map.containsKey(val))
            return false;

        list.add(val);

        map.put(val, list.size() - 1);

        return true;
    }

    public boolean remove(int val) {

        if (!map.containsKey(val))
            return false;

        int index = map.get(val);

        int last = list.get(list.size() - 1);

        list.set(index, last);

        map.put(last, index);

        list.remove(list.size() - 1);

        map.remove(val);

        return true;
    }

    public int getRandom() {

        int index = random.nextInt(list.size());

        return list.get(index);
    }

    public static void main(String[] args) {

        RandomizedSet rs = new RandomizedSet();

        rs.insert(10);
        rs.insert(20);
        rs.insert(30);

        System.out.println(rs.getRandom());

        rs.remove(20);

        System.out.println(rs.getRandom());
    }
}
