package revision13;

import java.util.*;

public class RepeatedDNA {

    public static List<String> findRepeated(String s){

        HashSet<String> seen = new HashSet<>();
        HashSet<String> repeated = new HashSet<>();

        for(int i=0;i<=s.length()-10;i++){

            String sub = s.substring(i,i+10);

            if(!seen.add(sub))
                repeated.add(sub);
        }

        return new ArrayList<>(repeated);
    }

    public static void main(String[] args){

        String dna =
                "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";

        System.out.println(findRepeated(dna));
    }
}
