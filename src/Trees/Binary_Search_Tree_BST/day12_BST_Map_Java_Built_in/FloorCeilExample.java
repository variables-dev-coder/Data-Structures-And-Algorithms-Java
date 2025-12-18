package Trees.Binary_Search_Tree_BST.day12_BST_Map_Java_Built_in;

import java.util.TreeMap;

public class FloorCeilExample {

    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();

        map.put(10, "A");
        map.put(20, "B");
        map.put(30, "C");
        map.put(40, "D");
        map.put(50, "E");

        int x = 25;

        Integer floor = map.floorKey(x);
        Integer ceil = map.ceilingKey(x);

        System.out.println("Floor of " + x + " = " + floor);
        System.out.println("Ceil of " + x + " = " + ceil);
    }
}

//Floor of 25 = 20
//Ceil of 25 = 30