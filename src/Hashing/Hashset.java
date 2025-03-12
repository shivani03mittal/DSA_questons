package Hashing;

import java.util.HashSet;
import java.util.Iterator;

public class Hashset {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(3);
        set.add(2);
        set.add(1);

        System.out.println(set.size());
        System.out.println(set);
        Iterator it = set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        if(set.contains(3)){
            System.out.println("yes");
        }else
            System.out.println("No");

        if(set.contains(5)){
            System.out.println("yes");
        }else
            System.out.println("No");

        set.remove(2);
        System.out.println(set);
    }
}
