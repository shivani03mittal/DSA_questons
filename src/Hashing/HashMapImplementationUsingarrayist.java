package Hashing;

import  java.util.*;
public class HashMapImplementationUsingarrayist {
    class MyHashMap {
        ArrayList<Integer> keyList;
        ArrayList<Integer> valList;

        public MyHashMap() {
            keyList= new ArrayList<>();
            valList= new ArrayList<>();

        }

        public void put(int key, int value) {
            if(keyList.contains(key)){
                int i=keyList.indexOf(key);
                valList.set(i,value);
            }else{
                keyList.add(key);
                valList.add(value);
            }
        }

        public int get(int key) {
            if(!keyList.contains(key)){
                return -1;
            }else{
                int i= keyList.indexOf(key);
                return valList.get(i);
            }

        }

        public void remove(int key) {
            if(keyList.contains(key)){
                int i= keyList.indexOf(key);
                keyList.remove(i);
                valList.remove(i);
            }

        }
    }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
}
