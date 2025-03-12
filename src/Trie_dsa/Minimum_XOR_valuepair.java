package Trie_dsa;

public class Minimum_XOR_valuepair {
    static class Trie{
        int numVal;
        Trie[] children = new Trie[2];

        public Trie(){
            numVal=0;
            children[0] = null;
            children[1] = null;

        }

    }

    static Trie root;

    static void insert(int num){
        Trie curr = root;
        for(int i = 31; i>=0 ;i--){
            int currBit = (num & (1<<i)) >=1 ? 1:0;
            if(curr != null && curr.children[currBit] == null){
                curr.children[currBit] = new Trie();
            }

            curr= curr.children[currBit];
        }
        //at leaf node add val
        curr.numVal = num;
    }

    static int minXORUtil(int num){

        Trie curr = root;
        for(int i = 31; i>=0 ;i--){
            int currBit = (num & (1<<i)) >=1 ? 1:0;

            if(curr.children[currBit] != null){
                curr= curr.children[currBit];
            }
            else if(curr.children[1-currBit] != null){
                curr = curr.children[1- currBit] ;
            }

        }
        return num ^ curr.numVal;

    }

    static int minxorpair(int N, int arr[]){
        // for(int i=0; i<N ;i++){
        //     insert(arr[i]);
        // }
        root = new Trie();
        int minXor= Integer.MAX_VALUE;
        insert(arr[0]);
        for(int i=1;i <N;i++){
            minXor = Math.min(minXor, minXORUtil(arr[i]));
            insert(arr[i]);
        }
        return minXor;
        // code here
    }
}
