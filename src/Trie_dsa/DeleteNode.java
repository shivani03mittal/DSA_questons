package Trie_dsa;
import java.util.*;

public class DeleteNode {

    class TrieNode {
        char content;
        boolean isEnd;
        int count;
        LinkedList<TrieNode> childList;

        public TrieNode(char c) {
            childList = new LinkedList<TrieNode>();
            isEnd = false;
            content = c;
            count = 0;
        }

        public TrieNode subNode(char c) {
            if (childList != null)
                for (TrieNode eachChild : childList)
                    if (eachChild.content == c)
                        return eachChild;
            return null;
        }

        class Solution {
            public void deleteKey(TrieNode root, char[] key) {
                TrieNode curr = root;
                for (char ch : key) {
                    curr = curr.subNode(ch);
                    if (curr == null) return;

                }
                curr.isEnd = false;
                //add code here.
            }
        }
    }
}
