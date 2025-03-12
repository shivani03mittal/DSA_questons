package Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Hashmap {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a",2);
        map.put("b",3);
        map.put("c",4);
        System.out.println(map);
        System.out.println(map.size());

        Set<String> keys = map.keySet();
        System.out.println(keys);

        for(Map.Entry<String,Integer> e: map.entrySet()){
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }
       if( map.containsKey("d")) System.out.println("yes");;
        map.remove("c");
        System.out.println(map);


    }
}
