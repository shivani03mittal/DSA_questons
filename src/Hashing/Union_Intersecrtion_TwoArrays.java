package Hashing;

import java.util.HashSet;

public class Union_Intersecrtion_TwoArrays {
    public static int Union(int[] a1, int[] a2){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<a1.length;i++){
            set.add(a1[i]);
        }
        for(int i =0;i< a2.length;i++){
            set.add(a2[i]);
        }
        return set.size();
    }
    public int intersection(int[] a1, int[] a2){
        HashSet<Integer> set = new HashSet<>();
        for(int i =0;i< a1.length;i++){
            set.add(a1[i]);
        }
        int count =0;
        for(int j =0; j< a2.length;j++){
            if(set.contains(a2[j])){
                count++;
                set.remove(a2[j]);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int arr1[]={7,3,9};
        int arr2[]= {6,3,9,2,9,4};

    }
}
