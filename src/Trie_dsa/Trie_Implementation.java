package Trie_dsa;

public class Trie_Implementation {
    static class Node{
        Node[] children;
        boolean endOfword;

        public Node(){
            children= new Node[26];
            endOfword=false;
            for (int i=0;i<children.length;i++){
                children[i]= null;
            }
        }
    }
    static Node root = new Node();

    public static void insert(String word){
        Node curr= root;
        for(int c =0; c<word.length();c++){
            int idx= word.charAt(c)-'a';
            if(curr.children[idx]== null){
                curr.children[idx]= new Node();
            }
            if(c==word.length()-1){
                curr.children[idx].endOfword= true;
            }
                curr= curr.children[idx];
        }
    }

    public static boolean search(String key){
        Node curr= root;
        for(int i = 0 ;i< key.length();i++){
            int idx = key.charAt(i) -'a';
            if(curr.children[idx] == null){
                return false;
            }
            if(i == key.length()-1 && curr.children[idx].endOfword== false){
                return false;
            }
            curr= curr.children[idx];
        }
        return true;
    }

    public static void main(String[] args) {
        String words[] ={"the","a","there","their","any"};
        for(int w =0;w< words.length;w++){
            insert(words[w]);
        }
        System.out.println(search("any"));
        System.out.println(search("thor"));


    }
}

// User function Template for Java

/*
static final int ALPHABET_SIZE = 26;

    // trie node
    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++) children[i] = null;
        }
    };
*/
//Function to insert string into TRIE.
//
//
//    static void insert(TrieNode root, String key)
//    {
//
//        TrieNode curr = root;
//        for(int i =0 ;i<key.length();i++){
//            int idx = key.charAt(i) -'a';
//            if(curr.children[idx] == null){
//                curr.children[idx] = new TrieNode();
//            }
//
//            curr= curr.children[idx];
//        }
//        curr.isEndOfWord= true;
//    }
//
//    //Function to use TRIE data structure and search the given string.
//    static boolean search(TrieNode root, String key)
//    {
//        // Your code here
//
//        TrieNode curr= root;
//        for(int i=0; i<key.length() ;i++){
//            int idx = key.charAt(i) -'a';
//            if(curr.children[idx]== null) return false;
//
//            curr= curr.children[idx];
//        }
//        return curr.isEndOfWord;
//
//
//    }