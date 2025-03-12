package Stack_queues;

import java.util.Stack;

public class reverseStack {
    /*
    * one way is to take another stack pop from original and push in second and then print that
    *
    * another method would be usnf recuursion
    * Bp: reverse n
    * sp: reverse n-1
    * work : push n at botom of reverse stack of n-1*/
    public static void pushatBottom(int data, Stack<Integer> s){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushatBottom(data,s);
        s.push(top);
    }
    public static void reverse(Stack<Integer>s){
        if(s.isEmpty()){
            return;
        }

        int top = s.pop();
        reverse(s);
        pushatBottom(top, s);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        reverse(s);

        while (!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
