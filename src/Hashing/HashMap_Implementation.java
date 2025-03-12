package Hashing;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMap_Implementation {
    static class HashMap<k,v>{// generics
        class Node{
            k key;
            v val;

            public Node(k key, v val){
                this.key= key;
                this.val= val;
            }
        }
        private int n;
        private int N;
        private LinkedList<Node> buckets[];

        @SuppressWarnings("unchecked")
        public HashMap(){
            this.N =4;
            this.buckets= new LinkedList[4];
            for (int i=0;i<4;i++){
                this.buckets[i]= new LinkedList<>();
            }
        }
        private int hashingFunc(k key){
            //hashcode returns hash from -x to x
            //so take abs value, this should be in range of [0,N-1]
            //so mod(%) the ab value by N
            int bi = key.hashCode();
            return Math.abs(bi) % N;
        }
        private int searchInLL(k key, int Buc_idx){
            //fetch ll
            LinkedList<Node> ll = buckets[Buc_idx];
            for(int i=0;i<ll.size();i++){
                if(ll.get(i).key== key) return i;
            }
            return -1;
        }

        private void rehash(){
            //fetch old bukets
            //make a new array of linkedlist of 2*size of old
            //initialize wit null lists
            //get each list ane each node and put again

            LinkedList<Node> oldBuckets[] = buckets;
            buckets= new LinkedList[2*N];
            for(int i =0;i<2*N;i++){
                buckets[i]= new LinkedList<>();
            }

            for(int i =0;i< oldBuckets.length;i++){
                LinkedList<Node> ll= oldBuckets[i];
                for(int j=0;j<ll.size();j++){
                    Node node = ll.get(j);
                    put(node.key, node.val);
                }
            }
        }
        public void put(k key, v val){
            //hasing and find bucket
            //serach if node exists
            //0 if yes : get the node and update val, 1: if no, create a new node and n++
            //cehck if lambda is > threshold: yes> reashing
            int bi = hashingFunc(key) ;
            int dataidx= searchInLL(key,bi);
            if(dataidx==-1){
                //does not exist
                buckets[bi].add(new Node(key,val));
                n++;
            }else{
                // data already there
                Node node = buckets[bi].get(dataidx);
                node.val= val;

            }
            double lambda= (double)n/N;
            if(lambda>2.0){
                //rehashing
                rehash();
            }
        }
        public v get(k key){
            //hasing and find bucket
            //serach if node exists
            //0 if yes : get the node return val, -1: if no, return null
            int bi = hashingFunc(key) ;
            int dataidx= searchInLL(key,bi);
            if(dataidx==-1){
                //does not exist
               return null;
            }else{
                // data already there
                Node node = buckets[bi].get(dataidx);
               return node.val;

            }
        }
        public boolean containsKey(k key){
            //hasing and find bucket
            //serach if node exists
            //0 if yes : return true, 1:false
            //cehck if lambda is > threshold: yes> reashing
            int bi = hashingFunc(key) ;
            int dataidx= searchInLL(key,bi);
            if(dataidx==-1){
                //does not exist
               return false;
            }else{
                // data already there
                return true;

            }
        }
        public v remove(k key){
            //hasing and find bucket
            //serach if node exists
            //0 if yes : get the node remove from ll and return val, 1: return null;
            //cehck if lambda is > threshold: yes> reashing
            int bi = hashingFunc(key) ;
            int dataidx= searchInLL(key,bi);
            if(dataidx==-1){
                //does not exist
               return null;
            }else{
                // data already there
                Node node = buckets[bi].remove(dataidx);
                n--;
                return node.val;

            }
        }
        public boolean isEmpty(){
            return n==0;
        }
        public ArrayList<k> ketSet(){
            ArrayList<k> keys = new ArrayList<>();
            for(int i =0;i<buckets.length;i++){
                LinkedList<Node> ll = buckets[i];
                for(int j=0;j<ll.size();j++){
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }

    }

    public static void main(String[] args) {
        HashMap<String ,Integer> map = new HashMap<>();
        map.put("a",11);
        map.put("b",12);

        ArrayList<String > keys=map.ketSet();
        System.out.println(keys);
    }

}
