package Stack_queues;

import java.util.Stack;

public class ImplementQueue_using2stacks {
    /* very optimal queue can not be done as either Push will be O(n) or Remove and peek will be
    * better to make 1 task o(n) hence push*/
    /*
    * pop from s1 to s2 till empty
    * puh in s1
    * pop s2 to s1 till empty*/

   static class Queue{
        static Stack <Integer> s1 = new Stack<>();
        static Stack <Integer> s2 = new Stack<>();

        public static boolean isEmpty(){
            return s1.isEmpty();
        }

        public static void add(int x){
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(x);
            while (!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        public static int remove(){
            if (isEmpty()){
                return -1;
            }
            return s1.pop();
        }
    }

    public static void main(String[] args) {

    }
}
