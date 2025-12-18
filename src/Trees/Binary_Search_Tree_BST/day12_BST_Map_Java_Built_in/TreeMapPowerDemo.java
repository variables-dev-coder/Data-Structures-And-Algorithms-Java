package Trees.Binary_Search_Tree_BST.day12_BST_Map_Java_Built_in;

import java.util.TreeMap;

public class TreeMapPowerDemo {

    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();

        map.put(50, "A");
        map.put(30, "B");
        map.put(70, "C");
        map.put(40, "D");

        System.out.println(map.get(30));          // B
        System.out.println(map.higherKey(40));    // 50
        System.out.println(map.lowerKey(40));     // 30
        System.out.println(map.subMap(30, 70));   // {30=B, 40=D, 50=A}
    }
}
