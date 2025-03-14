package Trie_dsa;

public class LongestWordwithallPrefix {
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
    public static String ans ="";
    public static void LongestWord(Node root, StringBuilder sb){
        if(root ==null)return;
        for(int i=0;i<26;i++){
            if(root.children[i] != null && root.children[i].eow==true){
                sb.append((char)( i+'a'));
                if(sb.length()> ans.length()){
                    ans= sb.toString();
                }
                LongestWord(root.children[i],sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        String[] words={"a","banana","app","appl","ap","apply","apple"};
        for(int i=0;i< words.length;i++){
            insert(words[i]);
        }
        LongestWord(root,new StringBuilder());
        System.out.println(ans);
    }

}
