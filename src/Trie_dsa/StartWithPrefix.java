package Trie_dsa;

public class StartWithPrefix {
    static class Node{
        Node[] children;
        boolean eow;

        public Node(){
            children= new Node[26];
            for(int i =0;i<children.length;i++){
                children[i]= null;
            }
            eow=false;
        }
    }
    static Node root = new Node();
    public static void insert(String word){
        Node curr= root;
        for(int i =0 ;i<word.length();i++){
            int idx = word.charAt(i)-'a';
            if( curr.children[idx]== null){
                curr.children[idx] = new Node();
            }
            if(i== word.length()-1){
                curr.children[idx].eow=true;
            }
            curr= curr.children[idx];
        }
    }
    public static boolean search(String key){
      Node curr = root;
        for(int i =0;i<key.length();i++){
            int idx = key.charAt(i)-'a';

            if( curr.children[idx] == null)return false;
            if(i == key.length()-1 &&  curr.children[idx].eow== false) return false;

            curr= curr.children[idx];
        }
        return true;
    }

    public static boolean startWithPrefix(String pref){
        Node curr = root;
        for(int i=0;i<pref.length();i++){
            int idx= pref.charAt(i)-'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr=curr.children[idx];
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words={"apple","app","mango","man","woman"};
        String prefix = "app";
        for(int i = 0;i< words.length;i++){
            insert(words[i]);
        }
        System.out.println(startWithPrefix(prefix));
    }
}
